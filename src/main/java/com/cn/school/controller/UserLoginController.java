package com.cn.school.controller;

import com.cn.school.FormView.UserInfoViewForm;
import com.cn.school.service.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "CustomRSAController",tags = {"用户登录"})
@ApiModel(value="用户登录",description="用户登录")
@RequestMapping("/UserLogin")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;


    @PostMapping(value = "/Login")
    @ApiOperation(value="用户登录")
    @ResponseBody
    public String userLogin(UserInfoViewForm form) {
        return userLoginService.userLogin(form);
    }
    @PostMapping(value = "/Register")
    @ApiOperation(value="用户注册")
    @ResponseBody
    public String register(UserInfoViewForm form) {
        return userLoginService.addUserInfo(form);
    }
}