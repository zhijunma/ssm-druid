package com.cn.school.service.impl;

import com.cn.school.FormView.DeleteGoodTypeViewForm;
import com.cn.school.entity.DSGoodType;
import com.cn.school.entity.mzj.GoodTypeViewForm;
import com.cn.school.mapper.GoodTypeManageMapper;
import com.cn.school.service.GoodTypeManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品类型业务逻辑实现
 * @author Administrator
 */
@Slf4j
@Service
public class GoodTypeManageServiceImpl implements GoodTypeManageService {

    @Autowired
    GoodTypeManageMapper goodTypeManageMapper;
    /**
     * 添加类型
     *
     * @param form
     * @return
     */
    @Override
    public String addGoodType(GoodTypeViewForm form) {
        DSGoodType ds = new DSGoodType();
        //接受前台的值
        ds.setTypeName(form.getTypeName());
        ds.setRemake(form.getRemake());
        ds.setAddTime(LocalDateTime.now());
        //进行处理
        Integer sta = goodTypeManageMapper.addGoodType(ds);
        if (sta >= 0){
            return "添加成功！";
        } else {
            return "添加失败！";
        }

    }

    /**
     * 删除类型
     *
     * @param form
     * @return
     */
    @Override
    public String deleteGoodType(DeleteGoodTypeViewForm form) {

        List<Long> list = form.getGoodTypeIdList();
        Integer sta = goodTypeManageMapper.deleteGoodType(list);

        if (sta >= 0){
            return "删除成功！";

        } else {
            return "删除失败！";
        }

    }

    /**
     * 修改类型
     *
     * @param form
     * @return
     */
    @Override
    public String updateGoodType(GoodTypeViewForm form) {
        DSGoodType ds = new DSGoodType();
        ds.setRemake(form.getRemake());
        ds.setTypeName(form.getTypeName());
        ds.setGoodTypeId(form.getGoodTypeId());
        Integer sta = goodTypeManageMapper.updateGoodType(ds);

        if (sta >= 0){
            return "修改成功！";
        } else {
            return "修改失败！";
        }

    }

    /**
     * 查看类型 可以有条件
     *
     * @param form
     * @return
     */
    @Override
    public List<GoodTypeViewForm> getGoodType(GoodTypeViewForm form) {
        DSGoodType ds = new DSGoodType();
        ds.setTypeName(form.getTypeName());
        ds.setRemake(form.getRemake());
        ds.setGoodTypeId(form.getGoodTypeId());

        List<DSGoodType> dsGoodTypes = goodTypeManageMapper.getGoodType(ds);
        List<GoodTypeViewForm> forms = new ArrayList<>(16);
        dsGoodTypes.forEach(e -> {
            GoodTypeViewForm viewForm = new GoodTypeViewForm();
            viewForm.setGoodTypeId(e.getGoodTypeId());
            viewForm.setRemake(e.getRemake());
            viewForm.setTypeName(e.getTypeName());
            viewForm.setAddTime(e.getAddTime());
            forms.add(viewForm);
        });

        return forms;

    }
}
