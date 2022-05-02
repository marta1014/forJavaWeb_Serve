package com.service;

import com.Mapper.BrandMapper;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Brand;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory =  SqlSessionFactoryUtil.getSqlSessionFactory();
    public List<Brand> forSelectAllBrand() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.selectAllBrand();
        sqlSession.close();

        return brandList;
    }

    public int updateBrandInfoItem(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int brandItem = brandMapper.updateBrandInfo(brand);
        sqlSession.commit();
        sqlSession.close();

        return brandItem;
    }

    public void deleteBrandById(JSONObject id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteBrandById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void batchesDeleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.batchesDeleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
