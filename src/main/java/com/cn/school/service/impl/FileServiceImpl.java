package com.cn.school.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.school.FormView.FileForm;
import com.cn.school.FormView.UploadFileForm;
import com.cn.school.FormView.VO.FileInfoVO;
import com.cn.school.entity.DSFileInfo;
import com.cn.school.mapper.DownloadLogMapper;
import com.cn.school.mapper.FileMapper;
import com.cn.school.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
     * @param fileForm
     * @return
     */
    @Override
    public String uploadFile(UploadFileForm fileForm) {
        String string = new String();
        if (!fileForm.getFileName().isEmpty()){
            string = fileForm.getFileName();
        } else {
           string = fileForm.getFile().getOriginalFilename();
        }



        Long s = fileForm.getFile().getSize();
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

        System.out.println(UPLOAD_FILE_PATH+fileForm.getFile().getOriginalFilename());
//        System.out.println(fileForm.getFile().getContentType()+"010101010110"+fileForm.getFileName()+fileForm.getContent());
        //判断不为空
        if (!fileForm.getFile().isEmpty()) {
            Map<String, String> resObj = new HashMap<>(MAP_SIZE);
            try {
                //上传文件
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(UPLOAD_FILE_PATH, fileForm.getFile().getOriginalFilename())));
                out.write(fileForm.getFile().getBytes());
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
            ds.setFileType(fileForm.getFile().getContentType());
            ds.setFileSize(size);
            ds.setContent(fileForm.getContent());
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
            return "网络不在线";
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
