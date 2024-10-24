package com.levent.service.article.service;


import com.levent.api.model.enums.OperateArticleEnum;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.ArticlePostReq;
import com.levent.api.model.vo.article.SearchArticleReq;
import com.levent.api.model.vo.article.dto.ArticleAdminDTO;

/**
 * 文章后台接口
 *
 * @author louzai
 * @date 2022-09-19
 */
public interface ArticleSettingService {

    /**
     * 更新文章
     *
     * @param req
     */
    void updateArticle(ArticlePostReq req);

    /**
     * 获取文章列表
     *
     * @param req
     * @return
     */
    PageVo<ArticleAdminDTO> getArticleList(SearchArticleReq req);

    /**
     * 删除文章
     *
     * @param articleId
     */
    void deleteArticle(Long articleId);

    /**
     * 操作文章
     *
     * @param articleId
     * @param operate
     */
    void operateArticle(Long articleId, OperateArticleEnum operate);
}
