package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Administrator
 */
@Data
public class DSFileInfo {
    /**
     * 主键ID
     */
    private Integer fileId;
    /**
     * 类型
     */
    private String fileType;
    /**
     * 路径
     */
    private String fileSrc;
    /**
     * 备注
     */
    private String content;
    /**
     * 大小
     */
    private String fileSize;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 添加者
     */
    private String addUser;
    /**
     * 添加者ID
     */
    private Integer addUserId;
    /**
     * 删除?
     */
    private boolean deleteFlag;
}
