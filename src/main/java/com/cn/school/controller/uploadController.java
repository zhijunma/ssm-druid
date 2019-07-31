package com.cn.school.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.DuplicateAttributeVerifier.MAP_SIZE;
@RestController
@Api(description = "uploadController",tags = {"上传文件"})
@ApiModel(value="上传文件",description="上传文件")
@RequestMapping(value = "/upload")
public class uploadController {
    public final static String UPLOAD_FILE_PATH = "D:\\data\\";

    @ApiOperation(value="上传文件")
    @PostMapping(value = "uploadFile")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            Map<String, String> resObj = new HashMap<>(MAP_SIZE);
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(UPLOAD_FILE_PATH, file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                resObj.put("msg", "error");
                resObj.put("code", "1");
                return JSONObject.toJSONString(resObj);
            }
            resObj.put("msg", "ok");
            resObj.put("code", "0");
            return JSONObject.toJSONString(resObj);
        } else {
            return null;
        }
    }
}
