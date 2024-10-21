package com.levent.service.article.service.impl;

import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.CategoryReq;
import com.levent.api.model.vo.article.SearchCategoryReq;
import com.levent.api.model.vo.article.dto.CategoryDTO;
import com.levent.service.article.service.CategorySettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 类目设置服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class CategorySettingServiceImpl implements CategorySettingService {
    @Override
    public void saveCategory(CategoryReq categoryReq) {
        
    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    @Override
    public void operateCategory(Integer categoryId, Integer pushStatus) {

    }

    @Override
    public PageVo<CategoryDTO> getCategoryList(SearchCategoryReq params) {
        return null;
    }
}
