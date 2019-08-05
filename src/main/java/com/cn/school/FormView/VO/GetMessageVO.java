package com.cn.school.FormView.VO;

import com.cn.school.DTO.GetMessageDTO;
import com.cn.school.entity.DSMessageInfo;
import lombok.Data;

import java.util.List;

/**
 * 获取消息
 */
@Data
public class GetMessageVO {
    /**
     * 已读消息
     */
    private List<GetMessageDTO> readMessage;
    /**
     * 未读消息
     */
    private List<GetMessageDTO> unreadMessage;


}
