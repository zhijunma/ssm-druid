package com.cn.school.service;

import com.cn.school.FormView.GetMessageForm;
import com.cn.school.FormView.VO.GetMessageVO;
import com.cn.school.FormView.VO.MessageInfoVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 通过添加人获取消息
     * @return
     */
    List<GetMessageVO> getMessageVOByVisitor();
    /**
     *
     * 通过添加人和状态获取消息
     * @param form
     * @return
     */
    List<MessageInfoVO> getMessageVOByVisitorAndStatus(GetMessageForm form);
    /**
     *
     * 根据添加人ID更新留言状态
     * @param form
     * @return
     */
    String updateStatusByVisitor(GetMessageForm form);
}
