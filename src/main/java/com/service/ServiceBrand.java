package com.service;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Brand;
import com.pojo.PageBean;

import java.util.List;

public interface ServiceBrand {
    List<Brand> forSelectAllBrand();

    int updateBrandInfoItem(Brand brand);

    void deleteBrandById(JSONObject id);

    void batchesDeleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);
}
