package com.example.demo;

import com.example.demo.Dao.RedisDao;
import com.example.demo.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudLearnRedisApplicationTests {

    @Autowired
    RedisDao redisDao;

    @Test
    public void contextLoads() {
        Product product = new Product();
        product.setId(1002l);
        product.setName("轮滑");
        product.setPrice("139.89");

        Assert.assertEquals(redisDao.putProduct(product), "OK");
        Assert.assertTrue(redisDao.getProduct(product.getId()).equals(product));
    }
}
