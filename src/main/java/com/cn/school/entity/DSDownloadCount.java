package com.cn.school.entity;

import lombok.Data;

/**
 * 下载总数实体
 * @author Administrator
 */
@Data
public class DSDownloadCount {
    /**
     * id
     */
    private Integer guid;
    /**
     * 总数
     */
    private Integer downloadCount;
}
