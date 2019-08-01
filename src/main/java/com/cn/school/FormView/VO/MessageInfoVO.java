package com.cn.school.FormView.VO;

import lombok.Data;

import java.time.LocalDate;
/**
 * 留言VO
 * @author Administrator
 */
@Data
public class MessageInfoVO {
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
     * 时间
     */
    private LocalDate addTime;
}
