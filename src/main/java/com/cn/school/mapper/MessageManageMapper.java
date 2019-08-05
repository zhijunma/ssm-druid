package com.cn.school.mapper;

import com.cn.school.DTO.GetMessageDTO;
import com.cn.school.entity.DSMessageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 获取消息
 * @author Administrator
 */
@Mapper
@Repository
public interface MessageManageMapper {
    /**
     * 获取已读消息
     * @return
     */
    List<GetMessageDTO> getReadMessage();
    /**
     * 获取未读消息
     * @return
     */
    List<GetMessageDTO> getUnreadMessage();
}
