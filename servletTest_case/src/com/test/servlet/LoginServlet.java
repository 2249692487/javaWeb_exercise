package com.test.servlet;

import com.test.domain.User;
import com.test.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2018/11/21
 */
public class LoginServlet extends HttpServlet {
    /**
     * 获取客户端提交的表单数据
     * 连接数据库
     * 执行查询语句
     * 获取查询结果集
     * 判断结果集,浏览器做出响应
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user where name=? and password=?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class),name,password);
            System.out.println(name+password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user==null){
            response.getWriter().write("fail");
        }else{
            response.getWriter().write("success");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
