package com.levent.service.user.service.relation;

import com.levent.api.model.vo.PageListVo;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.user.UserRelationReq;
import com.levent.api.model.vo.user.dto.FollowUserInfoDTO;
import com.levent.service.user.service.UserRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 用户关系服务
*@Version: 1.0
*/
@Slf4j
@Service
public class UserRelationServiceImpl implements UserRelationService {
    @Override
    public PageListVo<FollowUserInfoDTO> getUserFollowList(Long userId, PageParam pageParam) {
        return null;
    }

    @Override
    public PageListVo<FollowUserInfoDTO> getUserFansList(Long userId, PageParam pageParam) {
        return null;
    }

    @Override
    public void updateUserFollowRelationId(PageListVo<FollowUserInfoDTO> followList, Long loginUserId) {

    }

    @Override
    public Set<Long> getFollowedUserId(List<Long> userIds, Long loginUserId) {
        return Set.of();
    }

    @Override
    public void saveUserRelation(UserRelationReq req) {

    }
}
