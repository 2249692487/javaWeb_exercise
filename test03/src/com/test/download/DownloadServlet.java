package com.test.download;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2018/11/22
 */
@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 编写代码,无论什么文件
         * 都下载,不能打开
         * a.jpg做例子
         * * 指导浏览器什么做
         * 设置响应头 HTTP协议已经规定好了
         * Content-Disposition: attachment; filename =
         *                       附件
         */

        String agent = request.getHeader("User-Agent");
        String filename="美女.jpg";
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }


        response.setHeader("Content-Disposition","attachment; filename ="+filename);
        //获取图片的路径
        ServletContext context = getServletContext();
        String path = context.getRealPath("download/a.jpg");
        OutputStream out = response.getOutputStream();
        //字节输入流读取文件
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len = 0 ;
        while ((len=fis.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        fis.close();
    }
}
