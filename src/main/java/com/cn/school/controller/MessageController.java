package com.cn.school.controller;

import com.cn.school.FormView.AddMessageForm;
import com.cn.school.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 信息管理控制器
 */
@Api(description = "MessageController",tags = {"留言管理"})
@ApiModel(value="留言管理",description="留言管理")
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation(value="添加留言")
    public String addMessage(AddMessageForm form){

        return messageService.addMesaage(form);

    }
}
