package com.cn.school.service;

import com.cn.school.FormView.AddMessageForm;
import com.cn.school.FormView.GetMessageForm;
import com.cn.school.FormView.VO.MessageInfoVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 信息管理
 * @author Administrator
 */
@Transactional
public interface MessageService {
    /**
     * 添加信息
     * @param form
     * @return
     */
    String addMessage(AddMessageForm form);
    /**
     * 获取信息
     * @param form
     * @return
     */
    List<MessageInfoVO> selectMessage(GetMessageForm form);
}
