package com.cn.school.FormView;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Administrator
 */
@Data
public class GetMessageForm {
    /**
     * 主键
     */
    private Integer guid;
    /**
     * 访问者
     */
    private String addVisitor;
    /**
     * 访问者ID
     */
    private Integer addVisitorId;
    /**
     * 开始时间
     */
    private LocalDate addTime;
    /**
     * 结束时间
     */
    private LocalDate endTime;
    /**
     * 状态
     */
    private String status;
}
