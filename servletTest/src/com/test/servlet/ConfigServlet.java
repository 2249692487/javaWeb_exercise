package com.test.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2018/11/19
 */
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 获取ServletConfig对象
         * 通过父类的父类的方法  getServletConfig()
         */
        ServletConfig config =  getServletConfig();
        System.out.println(config);
        //config对象的方法,获取Servlet的名字
        String name = config.getServletName();
        System.out.println(name);
        //config对象获取Servlet的初始化参数
        String value = config.getInitParameter("heima");
        System.out.println(value);
        System.out.println("ConfigServlet  doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
