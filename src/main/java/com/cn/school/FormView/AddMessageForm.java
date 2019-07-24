package com.cn.school.FormView;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 添加人信息
 * @author Administrator
 */
@Data
public class AddMessageForm {
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
     * 拉黑？0：1
     */
    private String deleteFlag;
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
}
