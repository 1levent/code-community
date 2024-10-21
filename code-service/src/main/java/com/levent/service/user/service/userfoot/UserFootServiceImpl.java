package com.levent.service.user.service.userfoot;

import com.levent.api.model.enums.DocumentTypeEnum;
import com.levent.api.model.enums.OperateTypeEnum;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.user.dto.SimpleUserInfoDTO;
import com.levent.api.model.vo.user.dto.UserFootStatisticDTO;
import com.levent.service.comment.repository.entity.CommentDO;
import com.levent.service.user.repository.entity.UserFootDO;
import com.levent.service.user.service.UserFootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 用户足迹服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserFootServiceImpl implements UserFootService {
    @Override
    public UserFootDO saveOrUpdateUserFoot(DocumentTypeEnum documentType, Long documentId, Long authorId, Long userId, OperateTypeEnum operateTypeEnum) {
        return null;
    }

    @Override
    public void saveCommentFoot(CommentDO comment, Long articleAuthor, Long parentCommentAuthor) {

    }

    @Override
    public void removeCommentFoot(CommentDO comment, Long articleAuthor, Long parentCommentAuthor) {

    }

    @Override
    public List<Long> queryUserReadArticleList(Long userId, PageParam pageParam) {
        return List.of();
    }

    @Override
    public List<Long> queryUserCollectionArticleList(Long userId, PageParam pageParam) {
        return List.of();
    }

    @Override
    public List<SimpleUserInfoDTO> queryArticlePraisedUsers(Long articleId) {
        return List.of();
    }

    @Override
    public UserFootDO queryUserFoot(Long documentId, Integer type, Long userId) {
        return null;
    }

    @Override
    public UserFootStatisticDTO getFootCount() {
        return null;
    }
}

