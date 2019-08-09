package com.cn.school.mapper;

import com.cn.school.entity.DSAdminer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Mapper
@Repository
public interface LoginMapper {
    /**
     * 获取管理员信息
     * @param number
     * @return
     */
    DSAdminer getAdminerByNumber(@Param("number") Integer number);
}
