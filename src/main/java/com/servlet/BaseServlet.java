package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 统一封装一个servlet 使其继承 HttpServlet
 * 重写 service方法
 * req.getRequestURI() 获取短路径 并截取末端作为方法名
 *
 * this.getClass() 获取字节码对象 this => 每个servlet自对象
 *
 * 通过反射来获取方法对象并执行方法
 * getMethod 获取method对象
 *
 * method.invoke 执行方法
 */

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortUrl = req.getRequestURI();
        int index = sortUrl.lastIndexOf("/");
        String methodName = sortUrl.substring(index + 1);
        System.out.println(sortUrl);

        final Class<? extends BaseServlet> aClass = this.getClass();

        try {
            Method method = aClass.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);

            try {
                method.invoke(this,req,resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
