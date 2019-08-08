package com.cn.school.controller;

import com.cn.school.FormView.GetMessageForm;
import com.cn.school.FormView.VO.GetMessageVO;
import com.cn.school.FormView.VO.MessageInfoVO;
import com.cn.school.service.MessageManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @PostMapping(value = "/getByVisitor")
    @ResponseBody
    @ApiOperation(value="获取留言ByVisitor")
    public List<GetMessageVO> getMessagesByVisitor(){
        return messageManageService.getMessageVOByVisitor();
    }

    @PostMapping(value = "/getByVisitorAndStatus")
    @ResponseBody
    @ApiOperation(value="获取留言ByVisitorAndStatus")
    public List<MessageInfoVO> getByVisitorAndStatus(GetMessageForm form){
        return messageManageService.getMessageVOByVisitorAndStatus(form);
    }
    @PostMapping(value = "/updateStatusByVisitor")
    @ResponseBody
    @ApiOperation(value="更新留言状态ByVisitor")
    public String updateStatusByVisitor(GetMessageForm form){
        return messageManageService.updateStatusByVisitor(form);
    }
}
