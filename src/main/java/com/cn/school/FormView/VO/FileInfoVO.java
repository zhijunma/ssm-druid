package com.cn.school.FormView.VO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Administrator
 */
@Data
public class FileInfoVO {
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
}
