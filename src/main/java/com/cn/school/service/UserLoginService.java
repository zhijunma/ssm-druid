package com.cn.school.service;

import com.cn.school.FormView.UserInfoViewForm;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserLoginService {
    /**
     * 通过电话号码获取用户密码
     * @param form
     * @return
     */
    String userLogin(UserInfoViewForm form);

    /**
     * 添加用户信息
     * @param form
     * @return
     */
    String addUserInfo(UserInfoViewForm form);
}
