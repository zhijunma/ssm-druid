package com.cn.school.controller;

import com.cn.school.FormView.VO.GetMessageVO;
import com.cn.school.service.MessageManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 留言管理
 * @author Administrator
 */
@Api(description = "留言管理",tags = {"留言管理"})
@ApiModel(value = "留言管理",description = "留言管理")
@RestController
@RequestMapping(value = "messageManage")
public class MessageManageController {

    @Autowired
    MessageManageService messageManageService;
    @PostMapping(value = "/get")
    @ResponseBody
    @ApiOperation(value="获取留言")
    public GetMessageVO getMessages(){
        return messageManageService.getMessageVO();
    }
}
