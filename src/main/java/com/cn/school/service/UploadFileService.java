package com.cn.school.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件业务
 */

public interface UploadFileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);
}
