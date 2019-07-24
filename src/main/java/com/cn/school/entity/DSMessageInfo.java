package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * 信息实体类
 * @author Administrator
 */
@Data
public class DSMessageInfo {
    /**
     * 主键
     */
    private Integer guid;
    /**
     * 信息
     */
    private String message;
    /**
     * 访问者
     */
    private String addVisitor;
    /**
     * 访问者ID
     */
    private Integer addVisitorId;
    /**
     * 添加时间
     */
    private LocalDate addTime;
    /**
     * 拉黑？0：1
     */
    private String deleteFlag;
}
