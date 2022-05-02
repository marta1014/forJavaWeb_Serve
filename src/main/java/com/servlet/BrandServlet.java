package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.ServiceBrand;
import com.service.com.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private ServiceBrand brandService = new BrandServiceImpl();
    public void ServletForSelectAllBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brandList = brandService.forSelectAllBrand();
        if(brandList != null) {
            response.setStatus(200);
            String jsonData = JSON.toJSONString(brandList);
            response.setContentType("text/json;charset=utf-8");
            // response.setHeader("Access-Control-Allow-Origin","*");
            response.getWriter().write(jsonData);
        }
    }
    public void ServletForUpdateBrandInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Brand brand = JSON.parseObject(params,Brand.class);
        int result = brandService.updateBrandInfoItem(brand);
        response.getWriter().write(result);
    }

    public void ServletDeleteBrandById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        JSONObject id = JSON.parseObject(params);
        brandService.deleteBrandById(id);
        response.getWriter().write("success");
    }

    public void BatchesDeleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        int[] arr = JSON.parseObject(params,int[].class);
        brandService.batchesDeleteByIds(arr);
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        JSONObject obj = JSON.parseObject(params);
        int currentPage = (int) obj.get("currentPage");
        int pageSize = (int) obj.get("pageSize");
        PageBean<Brand> bean = brandService.selectByPage(currentPage,pageSize);
        System.out.println(bean);
        String jsonData = JSON.toJSONString(bean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonData);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        JSONObject obj = JSON.parseObject(params);
        int currentPage = (int) obj.get("currentPage");
        int pageSize = (int) obj.get("pageSize");
        Brand brand = JSON.parseObject(params,Brand.class);
        PageBean<Brand> bean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);

        String jsonData = JSON.toJSONString(bean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonData);
    }
}
