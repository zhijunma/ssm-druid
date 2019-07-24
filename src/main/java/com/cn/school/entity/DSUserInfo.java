package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DSUserInfo {
    /**
     * 主键
     */
    private Long userId;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 电话
     */
    private Long mobilePhone;
    /**
     * qq
     */
    private Long qq;
    /**
     * 性别
     */
    private Long sex;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 角色
     */
    private Long userRole;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 是否删除，0 否，1 是
     */
    private String deleteFlag;
}
