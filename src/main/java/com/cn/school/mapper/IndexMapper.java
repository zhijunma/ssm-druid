package com.cn.school.mapper;

import com.cn.school.DTO.FileCountDTO;
import com.cn.school.DTO.IndexDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *首页数据mapper
 * @author Administrator
 */
@Mapper
@Repository
public interface IndexMapper {
    /**
     * 获取文件数，点赞数，下载数
     * @return
     */
    IndexDTO getIndexCount();

    /**获取访问数
     *
     * @return
     */
    Integer getIndexVisitCount();
    /**
     * 获取未读消息数
     *
     * @return
     */
    Integer getIndexUnreadCount();

    /**
     * 获取文件类型下的文件数
     * @return
     */
    List<FileCountDTO> getFileCount();
}
