package com.cn.school.mapper;

import com.cn.school.entity.DSUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
@Repository
public interface UserInfoManageMapper {

    /**
     * 通过条件获取用户信息
     * @param ds
     * @return
     */
    List<DSUserInfo> getUserInfoByItem(@Param("ds") DSUserInfo ds);

    /**
     * 更新用户信息
     * @param ds
     * @return
     */
    Integer updateUserInfo(@Param("ds") DSUserInfo ds);
    /**
     * 更新用户信息
     * @return
     */
    List<DSUserInfo> getAllUsers();
    /**
     * 删除用户信息
     * @param list
     * @return
     */
    Integer deleteUser(@Param("list") List<Long> list);
}
