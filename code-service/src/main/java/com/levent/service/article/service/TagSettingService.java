package com.levent.service.article.service;


import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.article.SearchTagReq;
import com.levent.api.model.vo.article.TagReq;
import com.levent.api.model.vo.article.dto.TagDTO;

/**
 * 标签后台接口
 *
 * @author louzai
 * @date 2022-09-17
 */
public interface TagSettingService {

    void saveTag(TagReq tagReq);

    void deleteTag(Integer tagId);

    void operateTag(Integer tagId, Integer pushStatus);

    /**
     * 获取tag列表
     *
     * @param req
     * @return
     */
    PageVo<TagDTO> getTagList(SearchTagReq req);

    TagDTO getTagById(Long tagId);
}
