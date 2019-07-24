package com.cn.school.service.impl;

import com.cn.school.FormView.AddMessageForm;
import com.cn.school.entity.DSMessageInfo;
import com.cn.school.entity.DSVisitorInfo;
import com.cn.school.mapper.MessageMapper;
import com.cn.school.mapper.VisitorMapper;
import com.cn.school.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 信息管理
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    VisitorMapper visitorMapper;
    /**
     * 添加信息
     *
     * @param form
     * @return
     */
    @Override
    public String addMesaage(AddMessageForm form) {

        //访问者信息
        DSVisitorInfo dsVisitorInfo = new DSVisitorInfo();
        dsVisitorInfo.setVisitorName(form.getAddVisitor());
        dsVisitorInfo.setAddTime(LocalDate.now());
        dsVisitorInfo.setEmail(form.getEmail());
        dsVisitorInfo.setPhone(form.getPhone());
        dsVisitorInfo.setQq(form.getQq());
        dsVisitorInfo.setWx(form.getWx());
        //判断访问者是否曾经访问过
        List<DSVisitorInfo> visitors = visitorMapper.getCountTimeBySome(dsVisitorInfo);
        if (visitors.size() != 1){
            //添加用户
            Integer state = visitorMapper.addVisitor(dsVisitorInfo);
            if (state <= 0){
                return "添加失败！";
            } else {
                DSMessageInfo ds = new DSMessageInfo();
                ds.setMessage(form.getMessage());
                ds.setAddVisitor(dsVisitorInfo.getVisitorName());
                ds.setAddVisitorId(dsVisitorInfo.getGuid());
                ds.setAddTime(LocalDate.now());
                //添加留言
                Integer sta = messageMapper.addMessage(ds);
                if (sta <= 0) {
                    return "添加失败！";
                } else {
                    return "添加成功！";
                }
            }
        } else {

            DSMessageInfo countDs = new DSMessageInfo();
            countDs.setAddVisitorId(visitors.get(0).getGuid());
            countDs.setAddTime(LocalDate.now());
            Integer count = messageMapper.countMessage(countDs);
            if (count < 10) {
                //添加留言
                DSMessageInfo messageInfo = new DSMessageInfo();
                messageInfo.setMessage(form.getMessage());
                messageInfo.setAddVisitor(visitors.get(0).getVisitorName());
                messageInfo.setAddVisitorId(visitors.get(0).getGuid());
                messageInfo.setAddTime(LocalDate.now());
                //添加留言
                Integer sta = messageMapper.addMessage(messageInfo);
                if (sta <= 0) {
                    return "添加失败！";
                } else {
                    DSVisitorInfo updateInfo = new DSVisitorInfo();
                    updateInfo.setGuid(visitors.get(0).getGuid());
                    updateInfo.setCountTime(visitors.get(0).getCountTime() + 1);
                    Integer states = visitorMapper.updateCountTimeByGuid(updateInfo);
                    if (states <= 0) {
                        return "添加失败！";
                    } else {
                        return "添加成功！";
                    }

                }
            } else {
                return "一天最多留言10次！";
            }

        }
    }
}
