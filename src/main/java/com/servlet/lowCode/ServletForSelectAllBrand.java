package com.servlet.lowCode;

import com.alibaba.fastjson.JSON;
import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

// @WebServlet("/ServletForSelectAllBrand")
public class ServletForSelectAllBrand extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Brand> brandList = brandService.forSelectAllBrand();
//        if(brandList != null) {
//            response.setStatus(200);
//            String jsonData = JSON.toJSONString(brandList);
//            response.setContentType("text/json;charset=utf-8");
//            // response.setHeader("Access-Control-Allow-Origin","*");
//            response.getWriter().write(jsonData);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
