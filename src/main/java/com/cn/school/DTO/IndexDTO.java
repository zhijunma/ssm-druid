package com.cn.school.DTO;

import lombok.Data;

/**
 * 首页DTO
 * @author Administrator
 */
@Data
public class IndexDTO {
    /**
     * 文件总数
     */
    private Integer fileCount;
    /**
     * 点赞总数
     */
    private Integer praiseCount;
    /**
     * 下载总数
     */
    private Integer visitCount;
}
