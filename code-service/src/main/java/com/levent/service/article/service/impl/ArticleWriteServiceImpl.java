package com.levent.service.article.service.impl;

import com.levent.api.model.vo.article.ArticlePostReq;
import com.levent.service.article.service.ArticleWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 文章操作服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class ArticleWriteServiceImpl implements ArticleWriteService {
    @Override
    public Long saveArticle(ArticlePostReq req, Long author) {
        return 0L;
    }

    @Override
    public void deleteArticle(Long articleId, Long loginUserId) {

    }
}
