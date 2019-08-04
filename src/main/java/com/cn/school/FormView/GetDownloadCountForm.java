package com.cn.school.FormView;

import lombok.Data;

/**
 *下载总数form
 * @author Administrator
 */
@Data
public class GetDownloadCountForm {
    /**
     *文件ID
     */
    private Integer fileId;
    /**
     * 文件类型
     */
    private String fileType;
}
