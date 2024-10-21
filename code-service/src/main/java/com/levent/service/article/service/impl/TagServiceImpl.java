package com.levent.service.article.service.impl;

import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.dto.TagDTO;
import com.levent.service.article.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 标签服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class TagServiceImpl implements TagService {
    @Override
    public PageVo<TagDTO> queryTags(String key, PageParam pageParam) {
        return null;
    }

    @Override
    public Long queryTagId(String tag) {
        return 0L;
    }
}
