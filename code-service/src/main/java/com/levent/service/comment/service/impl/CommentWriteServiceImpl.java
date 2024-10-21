package com.levent.service.comment.service.impl;

import com.levent.api.model.vo.comment.CommentSaveReq;
import com.levent.service.comment.service.CommentWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 评论操作服务
*@Version: 1.0
*/
@Slf4j
@Service
public class CommentWriteServiceImpl implements CommentWriteService {
    @Override
    public Long saveComment(CommentSaveReq commentSaveReq) {
        return 0L;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) {

    }
}
