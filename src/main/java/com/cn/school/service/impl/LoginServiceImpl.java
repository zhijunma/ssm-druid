package com.cn.school.service.impl;

import com.cn.school.FormView.UserForm;
import com.cn.school.entity.DSAdminer;
import com.cn.school.mapper.LoginMapper;
import com.cn.school.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录
 * @author Administrator
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    /**
     * 登录
     *
     * @param userForm
     * @return
     */
    @Override
    public String login(UserForm userForm) {

        DSAdminer adminer = loginMapper.getAdminerByNumber(userForm.getAdminerNumber());
        if (adminer == null){
            return "账号不存在！";
        } else {
            if (!adminer.getAdminerNumber().equals(userForm.getAdminerNumber())){
                return "密码错误！";
            } else {
                return "登录成功！";
            }
        }
    }
}
