package com.cn.school.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.school.FormView.FileForm;
import com.cn.school.FormView.VO.FileInfoVO;
import com.cn.school.entity.DSFileInfo;
import com.cn.school.mapper.DownloadLogMapper;
import com.cn.school.mapper.FileMapper;
import com.cn.school.service.FileService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.DuplicateAttributeVerifier.MAP_SIZE;

/**
 *
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Value("${file.uploadFolder}")
    public String UPLOAD_FILE_PATH;

    @Autowired
    FileMapper fileMapper;
    @Autowired
    DownloadLogMapper downloadLogMapper;
    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public String uploadFile(MultipartFile file) {
        String string = file.getOriginalFilename();
        Long s = file.getSize();
        String size = s + "b";

        if (s/1024 != 0){
            s = s/1024;
            size = s + "k";
            if (s/1024 != 0){
                s = s/1024;
                size = s + "m";
                if (s/1024 != 0){
                    s = s/1024;
                    size = s + "g";
                }
            }
        }


        System.out.println(file.getContentType()+"        010101010110");
        //判断不为空
        if (!file.isEmpty()) {
            Map<String, String> resObj = new HashMap<>(MAP_SIZE);
            try {
                //上传文件
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(UPLOAD_FILE_PATH, file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                //失败返回消息
                resObj.put("msg", "error");
                resObj.put("code", "1");
                return JSONObject.toJSONString(resObj);
            }
            //成功执行操作
            DSFileInfo ds = new DSFileInfo();
            ds.setFileSrc(string);
            ds.setFileType(file.getContentType());
            ds.setFileSize(size);
            ds.setAddUserId(1);
            ds.setAddUser("mzj");
            ds.setAddTime(LocalDateTime.now());
            //返回消息
            Integer st = fileMapper.uploadFile(ds);
            if (st>0){
                resObj.put("msg", "ok");
                resObj.put("code", "0");
                return JSONObject.toJSONString(resObj);
            } else {
                //失败返回消息
                resObj.put("msg", "error");
                resObj.put("code", "1");
                return JSONObject.toJSONString(resObj);
            }
        } else {
            return null;
        }
    }

    /**
     * 获取文件信息
     *
     * @param file
     * @return
     */
    @Override
    public List<FileInfoVO> getFile(FileForm file) {

        List<FileInfoVO> vos = new ArrayList<>(16);
        List<DSFileInfo> dsFileInfos = new ArrayList<>(16);
        DSFileInfo ds = new DSFileInfo();
        ds.setFileId(file.getFileId());
        ds.setFileType(file.getFileType());
        ds.setAddUserId(file.getAddUserId());
        ds.setDeleteFlag(file.isDeleteFlag());
        dsFileInfos = fileMapper.getFiles(ds);
        dsFileInfos.forEach(e->{
            FileInfoVO vo = new FileInfoVO();

            vo.setFileId(e.getFileId());
            vo.setFileSrc(e.getFileSrc());
            vo.setSrce(UPLOAD_FILE_PATH+e.getFileSrc());
            vo.setFileType(e.getFileType());
            vo.setFileSize(e.getFileSize());
            vo.setAddTime(e.getAddTime());
            vo.setAddUser(e.getAddUser());
            vo.setAddUserId(e.getAddUserId());
            vo.setDownloadCount(downloadLogMapper.getCountOfDownload(e.getFileId()));
            vos.add(vo);
        });
        return vos;
    }
}
