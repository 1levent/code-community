package com.levent.api.model.vo.article;

import lombok.Data;

/**
 * 查询类目请求
 * @author levent
 * @date 2024/11/14
 */
@Data
public class SearchCategoryReq {
    // 类目名称
    private String category;
    // 分页
    private Long pageNumber;
    private Long pageSize;

}
