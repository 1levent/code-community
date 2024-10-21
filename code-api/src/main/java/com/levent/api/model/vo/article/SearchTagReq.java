package com.levent.api.model.vo.article;

import lombok.Data;

/**
 *查询标签请求
 * @author levent
 * @date 2024/11/08
 */
@Data
public class SearchTagReq {
    // 标签名称
    private String tag;
    // 分页
    private Long pageNumber;
    private Long pageSize;
}
