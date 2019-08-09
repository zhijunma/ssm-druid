package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Administrator
 */
@Data
public class DSAdminer {

    /**
     * 管理员ID
     */
    private Integer adminerId;
    /**
     * 管理员账号
     */
    private Integer adminerNumber;
    /**
     * 管理员姓名
     */
    private String adminerName;
    /**
     * 管理员密码
     */
    private String adminerPwd;
    /**
     * 管理员权限
     */
    private Integer role;

    private LocalDateTime addTime;
    private boolean deleteFlag;

}
