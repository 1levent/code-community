package com.levent.service.article.service.impl;

import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.SearchTagReq;
import com.levent.api.model.vo.article.TagReq;
import com.levent.api.model.vo.article.dto.TagDTO;
import com.levent.service.article.service.TagSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 标签设置服务
*@Version: 1.0
*/
@Slf4j
@Service
public class TagSettingServiceImpl implements TagSettingService {
    @Override
    public void saveTag(TagReq tagReq) {

    }

    @Override
    public void deleteTag(Integer tagId) {

    }

    @Override
    public void operateTag(Integer tagId, Integer pushStatus) {

    }

    @Override
    public PageVo<TagDTO> getTagList(SearchTagReq req) {
        return null;
    }

    @Override
    public TagDTO getTagById(Long tagId) {
        return null;
    }
}
