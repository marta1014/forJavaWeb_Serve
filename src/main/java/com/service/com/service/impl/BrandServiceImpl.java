package com.service.com.service.impl;

import com.Mapper.BrandMapper;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.ServiceBrand;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements ServiceBrand {
    SqlSessionFactory sqlSessionFactory =  SqlSessionFactoryUtil.getSqlSessionFactory();
    @Override
    public List<Brand> forSelectAllBrand() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.selectAllBrand();
        sqlSession.close();

        return brandList;
    }

    @Override
    public int updateBrandInfoItem(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int brandItem = brandMapper.updateBrandInfo(brand);
        sqlSession.commit();
        sqlSession.close();

        return brandItem;
    }

    @Override
    public void deleteBrandById(JSONObject id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteBrandById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void batchesDeleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.batchesDeleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Brand> brandList = brandMapper.selectByPage(begin,size);
        int total = brandMapper.selectTotalCount();

        PageBean<Brand> bean = new PageBean<>();
        bean.setRows(brandList);
        bean.setTotalCount(total);

        sqlSession.close();
        return bean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        // 处理brand
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }

        List<Brand> brandList = brandMapper.selectByPageAndCondition(begin,size,brand);
        int total = brandMapper.selectTotalCountByCondition(brand);

        PageBean<Brand> bean = new PageBean<>();
        bean.setRows(brandList);
        bean.setTotalCount(total);

        sqlSession.close();
        return bean;
    }
}
