package com.cn.school.mapper;

import com.cn.school.entity.DSGoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * 条件获取商品信息
 */
@Mapper
@Repository
public interface GoodsInfoMapper {
    /**
     * 条件获取商品信息
     * @param ds
     * @return
     */
    List<DSGoodsInfo> getGoodsinfo(@Param("ds") DSGoodsInfo ds);
    /**
     * 条件获取商品信息
     * @param ds
     * @return
     */
    List<DSGoodsInfo> addGoodsinfo(@Param("ds") DSGoodsInfo ds);
}
