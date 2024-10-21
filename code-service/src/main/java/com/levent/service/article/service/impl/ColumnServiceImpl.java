package com.levent.service.article.service.impl;

import com.levent.api.model.vo.PageListVo;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.article.dto.ColumnDTO;
import com.levent.api.model.vo.article.dto.SimpleArticleDTO;
import com.levent.service.article.repository.entity.ColumnArticleDO;
import com.levent.service.article.service.ColumnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 栏目服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class ColumnServiceImpl implements ColumnService {
    @Override
    public ColumnArticleDO getColumnArticleRelation(Long articleId) {
        return null;
    }

    @Override
    public PageListVo<ColumnDTO> listColumn(PageParam pageParam) {
        return null;
    }

    @Override
    public ColumnArticleDO queryColumnArticle(long columnId, Integer order) {
        return null;
    }

    @Override
    public ColumnDTO queryBasicColumnInfo(Long columnId) {
        return null;
    }

    @Override
    public ColumnDTO queryColumnInfo(Long columnId) {
        return null;
    }

    @Override
    public List<SimpleArticleDTO> queryColumnArticles(long columnId) {
        return List.of();
    }

    @Override
    public Long getTutorialCount() {
        return 0L;
    }
}
