package com.cn.school.controller;


import com.cn.school.FormView.FileForm;
import com.cn.school.FormView.UploadFileForm;
import com.cn.school.FormView.VO.FileInfoVO;
import com.cn.school.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Administrator
 */
@CrossOrigin
@RestController
@Api(description = "uploadController",tags = {"上传文件"})
@ApiModel(value="上传文件",description="上传文件")
@RequestMapping(value = "/upload")
public class UploadController {
    @Autowired
    FileService fileService;

    /**
     * 上传文件
     * @param fileForm
     * @return
     */
    @ApiOperation(value="上传文件")
    @PostMapping(value = "uploadFile")
    public String uploadFile(UploadFileForm fileForm) {
        return fileService.uploadFile(fileForm);
    }

    /**
     * 获取文件
     * @param file
     * @return
     */
    @ApiOperation(value="获取文件")
    @PostMapping(value = "getFile")
    public List<FileInfoVO> getFile(FileForm file) {
        return fileService.getFile(file);
    }
}
