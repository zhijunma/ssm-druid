package com.cn.school.FormView.VO;

import lombok.Data;

/**
 * 首页VO
 * @author Administrator
 */
@Data
public class IndexVO {
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
