package com.test.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2018/11/22
 */
@WebServlet(urlPatterns = "/Servlet7")
public class ChineseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response对象缓冲区的编码表
        //方法: setCharacterEncoding("编码表名")
        //response.setCharacterEncoding("utf-8");
        //通知浏览器,使用utf-8解码
        //response.getWriter().write("<meta charset='UTF-8'>");
        //设置响应类型
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("啦啦啦");

        System.out.println("-----------------------------------");
        response.addHeader("heima","java");
        response.addIntHeader("int",5);
        response.addDateHeader("date",System.currentTimeMillis());

        response.setHeader("heima","java2");

        //重定向 直接设置资源地址
        response.sendRedirect("/test03/Servlet5");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
