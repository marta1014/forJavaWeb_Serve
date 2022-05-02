package com.Mapper;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAllBrand();

    int updateBrandInfo(Brand brand);

    void deleteBrandById(JSONObject id);

    void batchesDeleteByIds(int[] arr);

    // 分页查询
    @Select("select * from tb_brand limit #{begin} , #{size};")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    // 查询总数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    // 分页 + 条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    // 查询总数 根据条件
    int selectTotalCountByCondition(Brand brand);
}
