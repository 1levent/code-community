package com.levent.service.article.repository.params;

import com.levent.api.model.vo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class SearchTagParams extends PageParam {
    // 标签名称
    private String tag;
}
