package com.cn.school.mapper;

import com.cn.school.FormView.VO.MessageInfoVO;
import com.cn.school.entity.DSMessageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 信息管理
 */
@Mapper
@Repository
public interface MessageMapper {
    /**
     * 添加信息
     * @param ds
     * @return
     */
    Integer addMessage(@Param("ds") DSMessageInfo ds);

    /**
     * 查看信息
     * @param ds
     * @return
     */
    List<MessageInfoVO> getMessage(@Param("ds") DSMessageInfo ds);

    /**
     * 统计一个人今天的留言数
     * @param ds
     * @return
     */
    Integer countMessage(@Param("ds") DSMessageInfo ds);
}
