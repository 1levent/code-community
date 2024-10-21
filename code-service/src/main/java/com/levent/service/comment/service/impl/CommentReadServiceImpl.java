package com.levent.service.comment.service.impl;

import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.comment.dto.TopCommentDTO;
import com.levent.service.comment.repository.entity.CommentDO;
import com.levent.service.comment.service.CommentReadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 评论接口服务
*@Version: 1.0
*/
@Slf4j
@Service
public class CommentReadServiceImpl implements CommentReadService {
    @Override
    public CommentDO queryComment(Long commentId) {
        return null;
    }

    @Override
    public List<TopCommentDTO> getArticleComments(Long articleId, PageParam page) {
        return List.of();
    }

    @Override
    public TopCommentDTO queryHotComment(Long articleId) {
        return null;
    }

    @Override
    public int queryCommentCount(Long articleId) {
        return 0;
    }
}
