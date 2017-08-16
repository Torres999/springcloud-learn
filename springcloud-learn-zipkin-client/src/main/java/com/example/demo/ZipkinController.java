package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: lilinlin
 * Date: 2017/6/30
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class ZipkinController {
    Logger logger = LoggerFactory.getLogger(ZipkinController.class);

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/zipkin", method = RequestMethod.GET)
    public int client(@RequestParam int b) {
        logger.info("Begin Zipkin Controller process!" + "Parameter is:" + b);
        return feignService.getService(b);
    }

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:9412";

    @RequestMapping("/service1")
    public String service1() throws Exception {
        logger.info("service1");
        String s = this.restTemplate.getForObject(url + "/service2", String.class);
        return s;
    }

    /**
     * request service without spring-cloud-sleuth-zipkin
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    @RequestMapping("/service2")
    public String service2(@RequestParam Integer a, @RequestParam Integer b) throws Exception {
        logger.info("service2");
        Map map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        Integer s = this.restTemplate.getForObject("http://localhost:1111/add?a=" + a + "&b=" + b, Integer.class);
        return String.valueOf(s);
    }

    /**
     * test RestTemplate with parameter
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    @RequestMapping("/service3")
    public String service3(@RequestParam Integer a, @RequestParam Integer b) throws Exception {
        logger.info("service3");

        String url = "http://localhost:1111/{path}";

        // URI (URL) parameters
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("path", "add");

        // Query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                // Add query parameter
                .queryParam("a", a)
                .queryParam("b", b);

        /**
         * Console output:http://localhost:1111/add?a=1&b=114
         */
        System.out.println(builder.buildAndExpand(uriParams).toUri());

//        Integer s = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),
//                HttpMethod.GET, Integer.class, class_p);

//        Map map = new HashMap<>();
//        map.put("a", a);
//        map.put("b", b);
//        Integer s = this.restTemplate.getForObject("http://localhost:1111/add", Integer.class, map);

        Integer s = this.restTemplate.getForObject(builder.buildAndExpand(uriParams).toUri(), Integer.class);
        return String.valueOf(s);
    }
}
