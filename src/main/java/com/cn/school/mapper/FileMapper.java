package com.cn.school.mapper;

import com.cn.school.entity.DSFileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文件管理
 */
@Mapper
@Repository
public interface FileMapper {
    /**
     * 上传
     * @param ds
     * @return
     */
    Integer uploadFile(@Param("ds") DSFileInfo ds);
    /**
     * 上传
     * @param ds
     * @return
     */
    List<DSFileInfo> getFiles(@Param("ds") DSFileInfo ds);
}
