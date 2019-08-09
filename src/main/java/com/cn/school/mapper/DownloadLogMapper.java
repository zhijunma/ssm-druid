package com.cn.school.mapper;

import com.cn.school.entity.DSDownloadCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Mapper
@Repository
public interface DownloadLogMapper {

    /**
     * 获取下载总数
     * @param guid
     * @return
     */
    Integer getCountOfDownload(@Param("guid") Integer guid);
}
