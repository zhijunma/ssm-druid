package com.cn.school.DTO;

import lombok.Data;

/**
 * 统计文件类型下的总数
 * @author Administrator
 */
@Data
public class FileCountDTO {

    private String fileType;

    private Integer fileCount;
}
