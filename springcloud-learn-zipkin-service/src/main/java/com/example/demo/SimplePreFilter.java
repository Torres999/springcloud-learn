//package com.example.demo;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
//import org.springframework.context.annotation.Bean;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//
///**
// * Created by IntelliJ IDEA.
// * User: lilinlin
// * Date: 2017/7/4
// * Time: 上午10:40
// * To change this template use File | Settings | File Templates.
// */
//public class SimplePreFilter extends ZuulFilter{
//    private static Logger log = LoggerFactory.getLogger(SimplePreFilter.class);
//
//    //Returns a String that stands for the type of the filter
//    //---in this case, pre, or it could be route for a routing filter.
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
////	  @Bean
////	  public AlwaysSampler defaultSampler() {
////	    return new AlwaysSampler();
////	  }
//
//    /*
//     * Need to override run() , it contains the functionality of the filter.
//     * @see com.netflix.zuul.IZuulFilter#run()
//     */
//    @Override
//    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        log.info(String.format("#####Hello recevied %s request for %s #####", request.getMethod(), request.getRequestURL().toString()));
//        log.info(String.format("#####For Zipkin::  Hello recevied %s request for %s #####", request.getMethod(), request.getRequestURL().toString()));
//
//
//        return null;
//    }
//}
