package com.levent.service.article.service.impl;

import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.*;
import com.levent.api.model.vo.article.dto.ColumnArticleDTO;
import com.levent.api.model.vo.article.dto.ColumnDTO;
import com.levent.api.model.vo.article.dto.SimpleColumnDTO;
import com.levent.service.article.service.ColumnSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 专栏设置服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class ColumnSettingServiceImpl implements ColumnSettingService {
    @Override
    public void saveColumnArticle(Long articleId, Long columnId) {
        
    }

    @Override
    public void saveColumn(ColumnReq columnReq) {

    }

    @Override
    public void saveColumnArticle(ColumnArticleReq req) {

    }

    @Override
    public void deleteColumn(Long columnId) {

    }

    @Override
    public void deleteColumnArticle(Long id) {

    }

    @Override
    public List<SimpleColumnDTO> listSimpleColumnBySearchKey(String key) {
        return List.of();
    }

    @Override
    public PageVo<ColumnDTO> getColumnList(SearchColumnReq req) {
        return null;
    }

    @Override
    public PageVo<ColumnArticleDTO> getColumnArticleList(SearchColumnArticleReq req) {
        return null;
    }

    @Override
    public void sortColumnArticleApi(SortColumnArticleReq req) {

    }

    @Override
    public void sortColumnArticleByIDApi(SortColumnArticleByIDReq req) {

    }
}
