package com.levent.web.front.article.vo;

import com.levent.api.model.vo.article.dto.ArticleDTO;
import com.levent.api.model.vo.article.dto.CategoryDTO;
import com.levent.api.model.vo.article.dto.TagDTO;
import lombok.Data;

import java.util.List;
@Data
public class ArticleEditVo {

    private ArticleDTO article;

    private List<CategoryDTO> categories;

    private List<TagDTO> tags;

}
