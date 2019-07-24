package com.cn.school.entity.mzj;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 商品类型
 */
@Data
public class GoodTypeViewForm {
    /**
     * 主键ID
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

}
