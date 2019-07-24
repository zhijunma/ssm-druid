package com.cn.school.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 商品类型
 */
@Data
public class DSGoodType {
    /**
     * 主键
     */
    private Long goodTypeId;
    /**
     * 名称
     */
    private String typeName;
    /**
     * 备注
     */
    private String remake;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 是否删除，0 否，1 是
     */
    private Long deleteFlag;

}
