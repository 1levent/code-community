package com.levent.service.article.service;


import com.levent.api.model.vo.PageListVo;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.article.dto.ArticleDTO;

/**
 * @author YiHui
 * @date 2022/9/26
 */
public interface ArticleRecommendService {
    /**
     * 文章关联推荐
     *
     * @param article
     * @param pageParam
     * @return
     */
    PageListVo<ArticleDTO> relatedRecommend(Long article, PageParam pageParam);
}
