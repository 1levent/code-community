package com.levent.service.article.service.impl;

import com.levent.api.model.enums.HomeSelectEnum;
import com.levent.api.model.vo.PageListVo;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.dto.ArticleDTO;
import com.levent.api.model.vo.article.dto.SimpleArticleDTO;
import com.levent.api.model.vo.article.dto.TagDTO;
import com.levent.service.article.repository.entity.ArticleDO;
import com.levent.service.article.service.ArticleReadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 文章阅读服务接口
 * @Version: 1.0
 */
@Slf4j
@Service
public class ArticleReadServiceImpl implements ArticleReadService {
    @Override
    public ArticleDO queryBasicArticle(Long articleId) {
        return null;
    }

    @Override
    public String generateSummary(String content) {
        return "";
    }

    @Override
    public PageVo<TagDTO> queryTagsByArticleId(Long articleId) {
        return null;
    }

    @Override
    public ArticleDTO queryDetailArticleInfo(Long articleId) {
        return null;
    }

    @Override
    public ArticleDTO queryFullArticleInfo(Long articleId, Long currentUser) {
        return null;
    }

    @Override
    public PageListVo<ArticleDTO> queryArticlesByCategory(Long categoryId, PageParam page) {
        return null;
    }

    @Override
    public List<ArticleDTO> queryTopArticlesByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public Long queryArticleCountByCategory(Long categoryId) {
        return 0L;
    }

    @Override
    public Map<Long, Long> queryArticleCountsByCategory() {
        return Map.of();
    }

    @Override
    public PageListVo<ArticleDTO> queryArticlesByTag(Long tagId, PageParam page) {
        return null;
    }

    @Override
    public List<SimpleArticleDTO> querySimpleArticleBySearchKey(String key) {
        return List.of();
    }

    @Override
    public PageListVo<ArticleDTO> queryArticlesBySearchKey(String key, PageParam page) {
        return null;
    }

    @Override
    public PageListVo<ArticleDTO> queryArticlesByUserAndType(Long userId, PageParam pageParam, HomeSelectEnum select) {
        return null;
    }

    @Override
    public PageListVo<ArticleDTO> buildArticleListVo(List<ArticleDO> records, long pageSize) {
        return null;
    }

    @Override
    public PageListVo<SimpleArticleDTO> queryHotArticlesForRecommend(PageParam pageParam) {
        return null;
    }

    @Override
    public int queryArticleCount(long authorId) {
        return 0;
    }

    @Override
    public Long getArticleCount() {
        return 0L;
    }
}
