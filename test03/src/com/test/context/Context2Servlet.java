package com.test.context;

import javax.servlet.ServletContext;
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
 * @data 2018/11/21
 */
public class Context2Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String realPath = sc.getRealPath("1.txt");
        System.out.println(realPath);
        sc = getServletContext();
        String realPath2 = sc.getRealPath("WEB_INF/2.txt");
        System.out.println(realPath2);
        sc = getServletContext();
        String realPath3 = sc.getRealPath("WEB_INF/classes/3.txt");
        System.out.println(realPath3);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
