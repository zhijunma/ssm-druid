package com.cn.school.service.impl;

import com.cn.school.FormView.VO.GetMessageVO;
import com.cn.school.mapper.MessageManageMapper;
import com.cn.school.service.MessageManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageManageServiceImpl implements MessageManageService {

    @Autowired
    MessageManageMapper manageMapper;
    /**
     * 获取消息
     *
     * @return
     */
    @Override
    public GetMessageVO getMessageVO() {

        GetMessageVO vo = new GetMessageVO();
        vo.setReadMessage(manageMapper.getReadMessage());
        vo.setUnreadMessage(manageMapper.getUnreadMessage());

        return vo;
    }
}
