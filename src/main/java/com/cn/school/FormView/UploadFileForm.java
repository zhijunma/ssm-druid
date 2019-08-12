package com.cn.school.FormView;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 *上传文件
 * @author Administrator
 */
@Data
public class UploadFileForm {

    private MultipartFile file;
    private String fileName;
    private String content;
}
