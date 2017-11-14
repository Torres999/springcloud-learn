package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * springboot如何家在自定义servlet，有两种方式：
 * 方式1：代码注册
 *      SpringcloudLearnConfigServerApplication.java里添加servletRegistrationBean()方法的方式
 *
 * 方式2：注解自动注册
 *      在MyServlet.java
 *
 * 该代码仅仅是展示如何加载自定义servlet，加载自定义filter、listener方式也一样，只是通过如下对象获得控制：
 *  API：ServletRegistrationBean、 FilterRegistrationBean 和 ServletListenerRegistrationBean
 *  注解：@WebServlet、@WebFilter、@WebListener
 *
 */
@LoadSelfServlet//方式2，通过@WebServlet注解+@ServletComponentScan注解
@WebServlet(urlPatterns="/xs/myservlet", description="Servlet的说明") // 不指定name的情况下，name默认值为类全路径，即org.springboot.sample.servlet.MyServlet2
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = -8685285401859800066L;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(">>>>>>>>>>init()<<<<<<<<<<<");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>大家好，我的名字叫Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
