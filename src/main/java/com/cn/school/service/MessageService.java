package com.cn.school.service;

import com.cn.school.FormView.AddMessageForm;
import com.cn.school.entity.DSMessageInfo;
import org.springframework.transaction.annotation.Transactional;

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
    String addMesaage(AddMessageForm form);
}
