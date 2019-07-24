package com.cn.school.service;

import com.cn.school.FormView.DeleteGoodTypeViewForm;
import com.cn.school.entity.mzj.GoodTypeViewForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Administrator
 */
@Transactional
public interface GoodTypeManageService {
    /**
     * 添加类型
     * @param form
     * @return
     */
    String addGoodType(GoodTypeViewForm form);

    /**
     * 删除类型
     * @param form
     * @return
     */
    String deleteGoodType(DeleteGoodTypeViewForm form);

    /**
     * 修改类型
     * @param form
     * @return
     */
    String updateGoodType(GoodTypeViewForm form);
    /**
     * 查看类型 可以有条件
     * @param form
     * @return
     */
    List<GoodTypeViewForm> getGoodType(GoodTypeViewForm form);

}
