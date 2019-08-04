package com.cn.school.controller;

import com.cn.school.FormView.VO.IndexVO;
import com.cn.school.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@Api(description = "IndexController", tags = {"首页数据控值"})
@ApiModel(value = "首页数据控值",description = "首页数据控值")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    IndexService indexService;
    /**
     * 首页数据传送
     * @return
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation(value="添加留言")
    public IndexVO indexInfo() {
        return indexService.getIndexInfo();
    }
}
