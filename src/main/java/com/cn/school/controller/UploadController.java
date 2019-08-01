package com.cn.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.school.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.DuplicateAttributeVerifier.MAP_SIZE;
/**
 * @author Administrator
 */
@RestController
@Api(description = "uploadController",tags = {"上传文件"})
@ApiModel(value="上传文件",description="上传文件")
@RequestMapping(value = "/upload")
public class UploadController {
    @Autowired
    UploadFileService uploadFileService;
//    public final static String UPLOAD_FILE_PATH = "D:\\data\\";
//    @Value("${file.uploadFolder}")
//    public String UPLOAD_FILE_PATH;
    @ApiOperation(value="上传文件")
    @PostMapping(value = "uploadFile")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
//        if (!file.isEmpty()) {
//            Map<String, String> resObj = new HashMap<>(MAP_SIZE);
//            try {
//                BufferedOutputStream out = new BufferedOutputStream(
//                        new FileOutputStream(new File(UPLOAD_FILE_PATH, file.getOriginalFilename())));
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//            } catch (IOException e) {
//                resObj.put("msg", "error");
//                resObj.put("code", "1");
//                return JSONObject.toJSONString(resObj);
//            }
//            resObj.put("msg", "ok");
//            resObj.put("code", "0");
//            return JSONObject.toJSONString(resObj);
//        } else {
//            return null;
//        }
        return uploadFileService.uploadFile(file);
    }
}
