package com.cn.school.service.impl;

import com.cn.school.DTO.IndexDTO;
import com.cn.school.FormView.VO.IndexVO;
import com.cn.school.mapper.IndexMapper;
import com.cn.school.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 首页数据实现类
 * @author Administrator
 */
@Slf4j
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public IndexVO getIndexInfo() {

        IndexDTO dto = indexMapper.getIndexCount();
        IndexVO vo = new IndexVO();
        vo.setPraiseCount(dto.getPraiseCount());
        vo.setFileCount(dto.getFileCount());
        vo.setUnreadCount(indexMapper.getIndexUnreadCount());
        vo.setVisitCount(indexMapper.getIndexVisitCount());
        vo.setFilesCount(indexMapper.getFileCount());
        return vo;
    }
}
