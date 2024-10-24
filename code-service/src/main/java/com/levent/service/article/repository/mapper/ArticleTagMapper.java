package com.levent.service.article.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.levent.api.model.vo.article.dto.TagDTO;
import com.levent.service.article.repository.entity.ArticleTagDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章标签映mapper接口
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTagDO> {

    /**
     * 查询文章标签
     *
     * @param articleId
     * @return
     */
    List<TagDTO> listArticleTagDetails(@Param("articleId") Long articleId);



}
