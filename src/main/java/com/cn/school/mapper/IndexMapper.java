package com.cn.school.mapper;

import com.cn.school.DTO.IndexDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

    /**
     *
     * @return
     */
    Integer getIndexVisitCount();
}
