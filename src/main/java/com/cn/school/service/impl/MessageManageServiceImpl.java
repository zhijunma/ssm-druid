package com.cn.school.service.impl;

import com.cn.school.DTO.GetMessageDTO;
import com.cn.school.FormView.GetMessageForm;
import com.cn.school.FormView.VO.GetMessageVO;
import com.cn.school.FormView.VO.MessageInfoVO;
import com.cn.school.entity.DSMessageInfo;
import com.cn.school.mapper.MessageManageMapper;
import com.cn.school.mapper.VisitorMapper;
import com.cn.school.service.MessageManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public List<MessageInfoVO> getMessageVOByVisitorAndStatus(GetMessageForm form) {
        List<MessageInfoVO> vos = new ArrayList<>(16);
        List<GetMessageDTO> dto = new ArrayList<>(16);
        //条件查询消息
        if (form.getStatus().equals("unread")) {
            dto = manageMapper.getUnreadMessageByVisitor(form.getAddVisitorId());
        } else {
            dto = manageMapper.getReadMessageByVisitor(form.getAddVisitorId());
        }
        //将需要传往前台的数据遍历添加vo中
        dto.forEach(e->{
            MessageInfoVO vo = new MessageInfoVO();
            vo.setAddTime(e.getAddTime());
            vo.setMessage(e.getMessage());
            vo.setAddVisitorId(e.getAddVisitorId());
            vo.setAddVisitor(e.getAddVisitor());
            vo.setEmail(e.getEmail());
            vo.setPhone(e.getPhone());
            vo.setQq(e.getQq());

            vos.add(vo);
        });

          return vos;
    }

    /**
     * 根据添加人ID更新留言状态
     *
     * @param form
     * @return
     */
    @Override
    public String updateStatusByVisitor(GetMessageForm form) {

        Integer i = manageMapper.updateStatusByAddVisitorId(form.getAddVisitorId(), LocalDateTime.now());
        if (i > 0) {
            return "你刚刚阅读了"+i+"条消息。";
        }else {
            return "数据库修改失败，请确定网络是否连接！";
        }
    }

    /**
     * 删除
     *
     * @return
     */
    @Override
    public String deleteByAddGuid() {
        LocalDateTime t = LocalDateTime.now();
        Integer i = manageMapper.deleteByAddGuid(t);
        if (i==0){
            return "删除失败";
        } else {
            return "删除了"+i+"消息";
        }
    }
}
