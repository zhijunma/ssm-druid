package com.cn.school.mapper;

import com.cn.school.entity.DSVisitorsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 访问者信息
 * @author Administrator
 */
@Mapper
@Repository
public interface VisitorMapper {
    /**
     * 添加访问者信息
     * @param ds
     * @return
     */
    Integer addVisitor(@Param("ds") DSVisitorsInfo ds);

    /**
     * 通过条件获取访问次数
     * @param ds
     * @return
     */
    List<DSVisitorsInfo> getCountTimeBySome(@Param("ds") DSVisitorsInfo ds);

    /**
     * 通过ID修改访问次数
     * @param ds
     * @return
     */
    Integer updateCountTimeByGuid(@Param("ds") DSVisitorsInfo ds);

}
