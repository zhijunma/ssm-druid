package com.cn.school.service;

import com.cn.school.FormView.VO.IndexVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 首页数据传送业务
 * @author Administrator
 */
@Transactional
public interface IndexService {
    /**
     * 获取点赞数，文件总数，访问数
     * @return
     */
    IndexVO getIndexInfo();
}
