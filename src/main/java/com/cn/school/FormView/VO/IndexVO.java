package com.cn.school.FormView.VO;

import com.cn.school.DTO.FileCountDTO;
import lombok.Data;

import java.util.List;

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
     * 未读消息总数
     */
    private Integer unreadCount;
    /**
     * 点赞总数
     */
    private Integer praiseCount;
    /**
     * 下载总数
     */
    private Integer visitCount;
    /**
     * 添加文件具体信息
     */
    private List<FileCountDTO> filesCount;
}
