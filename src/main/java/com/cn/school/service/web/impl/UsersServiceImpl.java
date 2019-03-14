package com.cn.school.service.web.impl;

import com.cn.school.dto.forms.usermanage.*;
import com.cn.school.dto.info.vo.GetCoachInfoVO;
import com.cn.school.dto.info.vo.GetUserInfoVO;
import com.cn.school.entity.DSUser;
import com.cn.school.mapper.web.UsersMapper;
import com.cn.school.mapstruct.UserMapStruct;
import com.cn.school.service.web.UsersService;
import com.cn.school.utils.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserMapStruct userMapStruct;
    /**
     * 学员
     */
    private final Integer stuRole = 1;

    /**
     * 用户查看个人信息
     *
     * @param userViewForm
     * @return
     */
    @Override
    public RestResponse getUser(GetUserViewForm userViewForm) {
        DSUser dsUser = usersMapper.getUser(userViewForm.getGuid());
        GetUserInfoVO getUserInfoVO = new GetUserInfoVO();
        getUserInfoVO.setPassword(dsUser.getPassword());
        getUserInfoVO.setIdCard(dsUser.getIdCard());
        getUserInfoVO.setMobilePhone(dsUser.getMobilePhone());
        getUserInfoVO.setRole(dsUser.getRole());
        getUserInfoVO.setStatus(dsUser.getStatus());
        getUserInfoVO.setUserName(dsUser.getUserName());
        return RestResponse.success(getUserInfoVO);
    }

    /**
     * 用户修改个人信息
     *
     * @param userViewForm
     * @return
     */
    @Override
    public RestResponse updateUsers(UpdateUserViewForm userViewForm) {
        Integer state = usersMapper.updateUsers(userViewForm.getGuid(), userViewForm.getPassword(), userViewForm.getMobilePhone(),userViewForm.getIdCard());
        if (state > 0) {
            return RestResponse.success("修改个人信息成功！");
        } else {
            return RestResponse.error("修改个人信息失败！");
        }

    }

    /**
     * 教练员添加，教练员信息只能由管理员添加
     *
     * @param insertCoachViewForm
     * @return
     */
    @Override
    public RestResponse insertCoach(InsertCoachViewForm insertCoachViewForm) {
        if (insertCoachViewForm.getCurrRole() != 3) {
            return RestResponse.error("权限不足！");
        }
        DSUser dsUser = new DSUser();
        dsUser.setUserName(insertCoachViewForm.getUserName());
        dsUser.setPassword(insertCoachViewForm.getPassword());
        dsUser.setMobilePhone(insertCoachViewForm.getMobilePhone());
        dsUser.setIdCard(insertCoachViewForm.getIdCard());
        dsUser.setRole(insertCoachViewForm.getRole());
        dsUser.setStatus(insertCoachViewForm.getStatus());
        dsUser.setAddUserId(insertCoachViewForm.getAddUserId());
        dsUser.setAddUser(insertCoachViewForm.getAddUser());
        dsUser.setAddTime(LocalDateTime.now());
        dsUser.setModUserId(insertCoachViewForm.getModUserId());
        dsUser.setModUser(insertCoachViewForm.getModUser());
        dsUser.setModTime(LocalDateTime.now());
        dsUser.setDeleteFlag(false);
        Integer state = usersMapper.insertCoach(dsUser);
        if (state > 0) {
            return RestResponse.success("添加教练员信息成功！");
        } else {
            return RestResponse.error("添加教练员信息失败！");
        }
    }

    /**
     * 教练员一览
     *
     * @param GetCoachsViewForm
     * @return
     */
    @Override
    public List getCoachs(GetCoachsViewForm GetCoachsViewForm) {
        //TODO 添加权限模块
        DSUser dsUser = new DSUser();
        dsUser.setUserName(GetCoachsViewForm.getUserName());
        dsUser.setMobilePhone(GetCoachsViewForm.getMobilePhone());
        dsUser.setIdCard(GetCoachsViewForm.getIdCard());

        List<DSUser> reDsUser = usersMapper.getCoachs(dsUser);
        List<GetCoachInfoVO> getCoachInfoVOList = new ArrayList<>(16);
        reDsUser.forEach(e -> {
            GetCoachInfoVO getCoachInfoVO = new GetCoachInfoVO();
            getCoachInfoVO.setGuid(e.getGuid());
            getCoachInfoVO.setUserName(e.getUserName());
            getCoachInfoVO.setRole(e.getRole());
            getCoachInfoVO.setMobilePhone(e.getMobilePhone());
            getCoachInfoVO.setIdCard(e.getIdCard());
            getCoachInfoVO.setStatus(e.getStatus());
            getCoachInfoVOList.add(getCoachInfoVO);
        });
        return getCoachInfoVOList;
    }

    /**
     * 教练员删除,假删除（更新状态）
     *
     * @param deleteCoachViewForm
     * @return
     */
    @Override
    public RestResponse deleteCoach(DeleteCoachViewForm deleteCoachViewForm) {
        if (deleteCoachViewForm.getCurrRole() != 3) {
            log.debug("权限不足!");
            return RestResponse.error("权限不足！");
        }
        DSUser dsUser = new DSUser();
        dsUser.setIdCard(deleteCoachViewForm.getIdCard());
        dsUser.setModUserId(deleteCoachViewForm.getModUserId());
        dsUser.setModUser(deleteCoachViewForm.getModUser());
        dsUser.setModTime(LocalDateTime.now());
        Integer state = usersMapper.deleteCoach(dsUser);
        if (state > 0) {
            return RestResponse.success("删除教练员成功！");
        } else {
            return RestResponse.error("删除教练员失败！");
        }
    }

    /**
     * 教练员详情查看（根据身份证号查询教练员）
     *
     * @param getCoachViewForm
     * @return
     */
    @Override
    public RestResponse getCoach(GetCoachViewForm getCoachViewForm) {
        if (getCoachViewForm.getCurrRole() != 3) {
            return RestResponse.error("权限不足！");
        }
        //入参
        DSUser dsUser = new DSUser();
        dsUser.setGuid(getCoachViewForm.getGuid());
        dsUser.setUserName(getCoachViewForm.getUserName());
        dsUser.setMobilePhone(getCoachViewForm.getMobilePhone());
        dsUser.setIdCard(getCoachViewForm.getIdCard());
        DSUser dsUser1 = usersMapper.getCoach(dsUser);
        //出参
        GetCoachInfoVO getCoachInfoVO = new GetCoachInfoVO();
        getCoachInfoVO.setGuid(dsUser1.getGuid());
        getCoachInfoVO.setUserName(dsUser1.getUserName());
        getCoachInfoVO.setRole(dsUser1.getRole());
        getCoachInfoVO.setMobilePhone(dsUser1.getMobilePhone());
        getCoachInfoVO.setIdCard(dsUser1.getIdCard());
        getCoachInfoVO.setStatus(dsUser1.getStatus());
        getCoachInfoVO.setAddTime(dsUser1.getAddTime());
        getCoachInfoVO.setAddUserId(dsUser1.getAddUserId());
        getCoachInfoVO.setAddUser(dsUser1.getAddUser());
        getCoachInfoVO.setModUserId(dsUser1.getModUserId());
        getCoachInfoVO.setModUser(dsUser1.getModUser());
        getCoachInfoVO.setModTime(dsUser1.getModTime());
        getCoachInfoVO.setDeleteFlag(dsUser1.getDeleteFlag());
        //判断是否查询到数据
//        if (RestResponse.success(getCoachInfoVO) != null) {
//            return RestResponse.success(getCoachInfoVO);
//        }else {
//            return RestResponse.success("没有符合条件的教练信息");
//        }
        return RestResponse.success(getCoachInfoVO);
    }


}
