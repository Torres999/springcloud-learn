package com.example.demo.Dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.example.demo.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/21
 * Time: 下午11:14
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RedisDao {
    Logger logger = LoggerFactory.getLogger(RedisDao.class);

    private final JedisPool jedisPool;

    private Schema<Product> schema = RuntimeSchema.getSchema(Product.class);

    public RedisDao() {
        this.jedisPool = new JedisPool("localhost", 6379);
    }

    public RedisDao(String ip, int port) {
        this.jedisPool = new JedisPool(ip, port);
    }

    public Product getProduct(Long productId) {
        logger.info("================== productId = [" + productId + "] ==================");
        Product product = new Product();
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "productId:" + productId;
                byte[] bytes = jedis.get(key.getBytes());
                //Redis 自己没有实现序列化
                //Google的protobuf性能最好(必须是标准的有访问器的pojo)
                ProtostuffIOUtil.mergeFrom(bytes, product, schema);
                logger.info("================== redis's productId = [" + product.getId() + "] ==================");
                logger.info("================== redis's productName = [" + product.getName() + "] ==================");
                logger.info("================== redis's productPrice = [" + product.getPrice() + "] ==================");

            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return product;
    }

    public String putProduct(Product product) {
        String result = null;
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "productId:" + product.getId();

                LinkedBuffer buffer = LinkedBuffer.allocate(4096);
                byte[] value = ProtostuffIOUtil.toByteArray(product, schema, buffer);

                result = jedis.set(key.getBytes(), value);
                logger.info("================== set Result : [" + result + "] ==================");
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
