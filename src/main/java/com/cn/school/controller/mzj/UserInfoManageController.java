package com.cn.school.controller.mzj;

import com.cn.school.FormView.DeleteUserViewFrom;
import com.cn.school.FormView.UserInfoViewForm;
import com.cn.school.entity.mzj.DSUserInfo;
import com.cn.school.service.mzj.UserInfoManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理
 * @author Administrator
 */
@RestController
@Api(description = "UserInfoManageController",tags = {"用户信息管理"})
@ApiModel(value="用户信息管理",description="用户信息管理")
@RequestMapping(value = "/UserInfoManage")
public class UserInfoManageController {
    @Autowired
    UserInfoManageService userInfoManageService;

    @PostMapping(value = "/getUserInfo")
    @ApiOperation(value="通过条件获取用户信息")
    @ResponseBody
    public List<DSUserInfo> getUserInfo(UserInfoViewForm form){
        return userInfoManageService.getUserInfo(form);
    }
    @PostMapping(value = "/updateUserInfo")
    @ApiOperation(value="更新用户信息")
    @ResponseBody
    public String updateUserInfo(UserInfoViewForm form){
        return userInfoManageService.updateUserInfo(form);
    }
    @PostMapping(value = "/getAllUsers")
    @ApiOperation(value="获取所有用户信息")
    @ResponseBody
    public List<UserInfoViewForm> getAllUsers(UserInfoViewForm form){
        return userInfoManageService.getAllUsers(form);
    }
    @PostMapping(value = "/deleteUser")
    @ApiOperation(value="删除用户信息")
    @ResponseBody
    public String deleteUser(DeleteUserViewFrom form){
        return userInfoManageService.deleteUser(form);
    }
}
