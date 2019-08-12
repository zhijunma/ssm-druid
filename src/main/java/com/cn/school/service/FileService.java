package com.cn.school.service;

import com.cn.school.FormView.FileForm;
import com.cn.school.FormView.UploadFileForm;
import com.cn.school.FormView.VO.FileInfoVO;
import com.cn.school.entity.DSFileInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件业务
 */
@Transactional
public interface FileService {
    /**
     * 上传文件
     * @param fileForm
     * @return
     */
    String uploadFile(UploadFileForm fileForm);
    /**
     * 获取文件
     * @param file
     * @return
     */
    List<FileInfoVO> getFile(FileForm file);
}
