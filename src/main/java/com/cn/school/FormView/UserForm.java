package com.cn.school.FormView;

import lombok.Data;

/**
 * 账号密码
 * @author Administrator
 */
@Data
public class UserForm {
    /**
     * 管理员账号
     */
    private Integer adminerNumber;
    /**
     * 管理员密码
     */
    private String adminerPwd;
}
