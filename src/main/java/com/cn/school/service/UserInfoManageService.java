package com.cn.school.service;


import com.cn.school.FormView.DeleteUserViewFrom;
import com.cn.school.FormView.UserInfoViewForm;
import com.cn.school.entity.DSUserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */
@Transactional
public interface UserInfoManageService {
    /**
     * 通过guid获取用户信息
     * @param form
     * @return
     */
    List<DSUserInfo> getUserInfo(UserInfoViewForm form);

    /**
     * 修改信息
     * @param form
     * @return
     */
    String updateUserInfo(UserInfoViewForm form);

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfoViewForm> getAllUsers(UserInfoViewForm form);

    /**
     * 删除用户
     * @param form
     * @return
     */
    String deleteUser (DeleteUserViewFrom form);
}
