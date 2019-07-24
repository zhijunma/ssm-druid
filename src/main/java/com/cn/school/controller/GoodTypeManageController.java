package com.cn.school.controller;

import com.cn.school.FormView.DeleteGoodTypeViewForm;
import com.cn.school.entity.mzj.GoodTypeViewForm;
import com.cn.school.service.GoodTypeManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goodType")
@Api(description = "GoodsInfoController",tags = {"商品类型管理"})
@ApiModel(value="商品类型管理",description="商品类型管理")
public class GoodTypeManageController {

    @Autowired
    GoodTypeManageService goodTypeManageService;

    @ApiOperation(value="添加类型")
    @PostMapping(value = "/add")
    @ResponseBody
    public String addGoodType(GoodTypeViewForm form){
        return goodTypeManageService.addGoodType(form);
    }
    @ApiOperation(value="删除类型")
    @PostMapping(value = "/delete")
    @ResponseBody
    public String deleteGoodType(DeleteGoodTypeViewForm form){
        return goodTypeManageService.deleteGoodType(form);
    }
    @ApiOperation(value="修改类型")
    @PostMapping(value = "/update")
    @ResponseBody
    public String updateGoodType(GoodTypeViewForm form){
        return goodTypeManageService.updateGoodType(form);
    }
}
