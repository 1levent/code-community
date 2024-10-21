package com.levent.service.article.service.impl;

import com.levent.api.model.vo.PageListVo;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.article.dto.ArticleDTO;
import com.levent.service.article.service.ArticleRecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 文章推荐服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class ArticleRecommendServiceImpl implements ArticleRecommendService {
    @Override
    public PageListVo<ArticleDTO> relatedRecommend(Long article, PageParam pageParam) {
        return null;
    }
}
