package com.levent.service.article.service.impl;


import com.levent.api.model.vo.PageListVo;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.article.dto.ArticleDTO;
import com.levent.service.article.repository.dao.ArticleDao;
import com.levent.service.article.repository.dao.ArticleTagDao;
import com.levent.service.article.repository.entity.ArticleDO;
import com.levent.service.article.repository.entity.ArticleTagDO;
import com.levent.service.article.service.ArticleReadService;
import com.levent.service.article.service.ArticleRecommendService;
import com.levent.service.sidebar.service.SidebarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YiHui
 * @date 2022/9/26
 */
@Service
public class ArticleRecommendServiceImpl implements ArticleRecommendService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleTagDao articleTagDao;
    @Autowired
    private ArticleReadService articleReadService;
    @Autowired
    private SidebarService sidebarService;

    /**
     * 查询文章关联推荐列表
     *
     * @param articleId
     * @param page
     * @return
     */
    @Override
    public PageListVo<ArticleDTO> relatedRecommend(Long articleId, PageParam page) {
        //获取这篇文章
        ArticleDO article = articleDao.getById(articleId);
        if (article == null) {
            return PageListVo.emptyVo();
        }
        //获取文章的标签ids
        List<Long> tagIds = articleTagDao.listArticleTags(articleId).stream()
                .map(ArticleTagDO::getTagId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(tagIds)) {
            return PageListVo.emptyVo();
        }
        //根据类目及标签进行推荐
        List<ArticleDO> recommendArticles = articleDao.listRelatedArticlesOrderByReadCount(article.getCategoryId(), tagIds, page);
        //排除本文章
        if (recommendArticles.removeIf(s -> s.getId().equals(articleId))) {
            // 移除推荐列表中的当前文章
            page.setPageSize(page.getPageSize() - 1);
        }
        return articleReadService.buildArticleListVo(recommendArticles, page.getPageSize());
    }
}
