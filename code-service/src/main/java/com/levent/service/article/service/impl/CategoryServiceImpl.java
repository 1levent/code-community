package com.levent.service.article.service.impl;

import com.levent.api.model.vo.article.dto.CategoryDTO;
import com.levent.service.article.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 类目服务
*@Version: 1.0
*/
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public String queryCategoryName(Long categoryId) {
        return "";
    }

    @Override
    public List<CategoryDTO> loadAllCategories() {
        return List.of();
    }

    @Override
    public Long queryCategoryId(String category) {
        return 0L;
    }

    @Override
    public void refreshCache() {

    }
}
