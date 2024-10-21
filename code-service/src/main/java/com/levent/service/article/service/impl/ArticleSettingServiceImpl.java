package com.levent.service.article.service.impl;

import com.levent.api.model.enums.OperateArticleEnum;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.ArticlePostReq;
import com.levent.api.model.vo.article.SearchArticleReq;
import com.levent.api.model.vo.article.dto.ArticleAdminDTO;
import com.levent.service.article.service.ArticleSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 文章设置服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class ArticleSettingServiceImpl implements ArticleSettingService {
    @Override
    public void updateArticle(ArticlePostReq req) {
        
    }

    @Override
    public PageVo<ArticleAdminDTO> getArticleList(SearchArticleReq req) {
        return null;
    }

    @Override
    public void deleteArticle(Long articleId) {

    }

    @Override
    public void operateArticle(Long articleId, OperateArticleEnum operate) {

    }
}
