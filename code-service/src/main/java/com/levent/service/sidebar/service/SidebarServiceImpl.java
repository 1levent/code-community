package com.levent.service.sidebar.service;

import com.levent.api.model.vo.recommend.SideBarDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 侧边栏服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class SidebarServiceImpl implements SidebarService{
    @Override
    public List<SideBarDTO> queryHomeSidebarList() {
        return List.of();
    }

    @Override
    public List<SideBarDTO> queryColumnSidebarList() {
        return List.of();
    }

    @Override
    public List<SideBarDTO> queryArticleDetailSidebarList(Long author, Long articleId) {
        return List.of();
    }
}
