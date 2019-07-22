package com.cn.school.service.mzj.impl;

import com.cn.school.FormView.DeleteUserViewFrom;
import com.cn.school.FormView.UserInfoViewForm;
import com.cn.school.entity.mzj.DSUserInfo;
import com.cn.school.mapper.mzj.UserInfoManageMapper;
import com.cn.school.service.mzj.UserInfoManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserInfoManageServiceImpl implements UserInfoManageService {
    @Autowired
    UserInfoManageMapper userInfoManageMapper;

    /**
     * 获取用户信息
     * @param form
     * @return
     */
    @Override
    public List<DSUserInfo> getUserInfo(UserInfoViewForm form) {

        DSUserInfo ds = new DSUserInfo();
        ds.setUserId(form.getUserId());
        ds.setQq(form.getQq());
        ds.setMobilePhone(form.getMobilePhone());
        ds.setSex(ds.getSex());
        ds.setUserName(form.getUserName());
        List<DSUserInfo> userInfoList = userInfoManageMapper.getUserInfoByItem(ds);
        return userInfoList;
    }

    /**
     * 修改信息实现类
     * @param form
     * @return
     */
    @Override
    public String updateUserInfo(UserInfoViewForm form) {
        //新建一个对象用来缓存信息
        DSUserInfo dsUserInfo = new DSUserInfo();
        //读取前台传来的值
        //主键id
        dsUserInfo.setUserId(form.getUserId());
        //用户姓名
        dsUserInfo.setUserName(form.getUserName());
        //电话即账号
        dsUserInfo.setMobilePhone(form.getMobilePhone());
        //地址
        dsUserInfo.setAddress(form.getAddress());
        //邮箱
        dsUserInfo.setEmail(form.getEmail());
        //QQ
        dsUserInfo.setQq(form.getQq());
        //执行修改方法
        Integer sta = userInfoManageMapper.updateUserInfo(dsUserInfo);
        //判断是否修改成功
        if (sta <= 0){
            return "修改失败!";
        } else {
            return "修改成功！";
        }

    }

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<UserInfoViewForm> getAllUsers(UserInfoViewForm userInfoViewForm) {
        if (userInfoViewForm.getUserRole() >= 1) {
            List<DSUserInfo> dsUserInfos = userInfoManageMapper.getAllUsers();
            List<UserInfoViewForm> userInfoList = new ArrayList<>(16);
            dsUserInfos.forEach(e -> {
                UserInfoViewForm form = new UserInfoViewForm();
                form.setUserId(e.getUserId());
                form.setUserName(e.getUserName());
                form.setUserPassword(e.getUserPassword());
                form.setMobilePhone(e.getMobilePhone());
                form.setSex(e.getSex());
                form.setAddress(e.getAddress());
                form.setEmail(e.getEmail());
                form.setQq(e.getQq());
                form.setAddTime(e.getAddTime());
                form.setUserRole(e.getUserRole());
                form.setDeleteFlag(e.getDeleteFlag());
                userInfoList.add(form);
            });
            return userInfoList;
        } else {
            return null;
        }
    }

    /**
     * 删除用户
     *
     * @param form
     * @return
     */
    @Override
    public String deleteUser(DeleteUserViewFrom form) {
        List<Long> userIdList = form.getUserIdList();
        Integer sta = userInfoManageMapper.deleteUser(userIdList);
        if (sta>=0){
            return "删除成功";
        } else {
            return "删除失败";
        }

    }


}
