package com.cn.school.FormView;

import lombok.Data;

import java.util.List;


/**
 * @author Administrator
 */
@Data
public class DeleteUserViewFrom {
    /**
     * 要删除的用户列表
     */
    private List<Long> userIdList;
    /**
     * 当前管理员
     */
    private String carrentUser;
}
