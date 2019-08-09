package com.cn.school.controller;


import com.cn.school.FormView.UserForm;
import com.cn.school.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 * @author Administrator
 */
@Api(description = "LoginController",tags = {"登录"})
@ApiModel(value="登录",description="登录")
@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 登录
     * @param userForm
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    @ApiOperation(value="登录")
    public String login(UserForm userForm){

        return loginService.login(userForm);

    }


}
