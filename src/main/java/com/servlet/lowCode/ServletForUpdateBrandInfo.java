package com.servlet.lowCode;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

// @WebServlet("/ServletForUpdateBrandInfo")
public class ServletForUpdateBrandInfo extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader br = request.getReader();
//        String params = br.readLine();
//        Brand brand = JSON.parseObject(params,Brand.class);
//        System.out.println(brand.toString());
//        int result = brandService.updateBrandInfoItem(brand);
//        response.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }
}
