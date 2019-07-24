package com.cn.school.mapper;

import com.cn.school.entity.DSGoodType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类型管理
 */
@Mapper
@Repository
public interface GoodTypeManageMapper {
    /**
     * 添加类型
     * @param ds
     * @return
     */
    Integer addGoodType(@Param("ds")DSGoodType ds);

    /**
     * 删除类型
     * @param list
     * @return
     */
    Integer deleteGoodType(@Param("list")List<Long> list);
    /**
     * 修改类型
     * @param ds
     * @return
     */
    Integer updateGoodType(@Param("ds") DSGoodType ds);
    /**
     * 查看类型 可以输入条件
     * @param ds
     * @return
     */
    List<DSGoodType> getGoodType(@Param("ds") DSGoodType ds);

}
