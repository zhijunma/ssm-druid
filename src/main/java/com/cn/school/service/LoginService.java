package com.cn.school.service;

import com.cn.school.FormView.UserForm;
import org.springframework.transaction.annotation.Transactional;

/**
 * 登录
 * @author Administrator
 */
@Transactional
public interface LoginService {
    /**
     * 登录
     * @param userForm
     * @return
     */
    String login(UserForm userForm);
}