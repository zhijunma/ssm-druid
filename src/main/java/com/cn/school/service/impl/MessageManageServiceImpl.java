package com.cn.school.service.impl;

import com.cn.school.FormView.VO.GetMessageVO;
import com.cn.school.mapper.MessageManageMapper;
import com.cn.school.mapper.VisitorMapper;
import com.cn.school.service.MessageManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MessageManageServiceImpl implements MessageManageService {

    @Autowired
    MessageManageMapper manageMapper;
    @Autowired
    VisitorMapper visitorMapper;
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

    /**
     * 通过添加人获取消息
     *
     * @return
     */
    @Override
    public List<GetMessageVO> getMessageVOByVisitor() {

        List<Integer> visitorId = visitorMapper.getVisitorId();

        List<GetMessageVO> vos = new ArrayList<>(16);

        visitorId.forEach(e->{
            GetMessageVO vo = new GetMessageVO();
            vo.setUnreadMessage(manageMapper.getUnreadMessageByVisitor(e));
            vo.setReadMessage(manageMapper.getReadMessageByVisitor(e));
            vos.add(vo);
        });
        return vos;
    }
}
