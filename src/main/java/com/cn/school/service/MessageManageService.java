package com.cn.school.service;

import com.cn.school.FormView.VO.GetMessageVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 留言管理
 * @author Administrator
 */
@Transactional
public interface MessageManageService {
    /**
     * 获取消息
     * @return
     */
    GetMessageVO getMessageVO();
}
