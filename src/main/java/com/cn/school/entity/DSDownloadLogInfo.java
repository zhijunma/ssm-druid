package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 下载日志实体
 * @author Administrator
 */
@Data
public class DSDownloadLogInfo {
    /**
     * 主键
     */
    private Integer downloadId;
    /**
     * 文件表主键
     */
    private Integer fileId;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
}
