package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * 添加人信息
 * @author Administrator
 */
@Data
public class DSVisitorsInfo {
    /**
     * 主键
     */
    private Integer guid;
    /**
     * 访问者姓名
     */
    private String visitorName;
    /**
     * 电话
     */
    private Long phone;
    /**
     * QQ
     */
    private Long qq;
    /**
     * 微信
     */
    private String wx;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 添加时间
     */
    private LocalDate addTime;
    /**
     * 拉黑？0：1
     */
    private String deleteFlag;
    /**
     * 计数器
     */
    private Long countTime;
}
