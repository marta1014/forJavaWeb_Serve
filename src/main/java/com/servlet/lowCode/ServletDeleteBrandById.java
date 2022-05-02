package com.servlet.lowCode;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

// @WebServlet("/ServletDeleteBrandById")
public class ServletDeleteBrandById extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader br = request.getReader();
//        String params = br.readLine();
//        // params => {"id":{"brandName":"myBatis","companyName":"hello myBatis","description":"hi ","id":1,"ordered":1,"status":0}}
//        System.out.println(JSON.parseObject(params, Brand.class));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }
}
