package com.levent.service.user.service.user;

import com.levent.api.model.vo.user.UserInfoSaveReq;
import com.levent.api.model.vo.user.UserPwdLoginReq;
import com.levent.api.model.vo.user.dto.BaseUserInfoDTO;
import com.levent.api.model.vo.user.dto.SimpleUserInfoDTO;
import com.levent.api.model.vo.user.dto.UserStatisticInfoDTO;
import com.levent.service.user.repository.entity.UserDO;
import com.levent.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 用户服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDO getWxUser(String wxuuid) {
        return null;
    }

    @Override
    public List<SimpleUserInfoDTO> searchUser(String userName) {
        return List.of();
    }

    @Override
    public void saveUserInfo(UserInfoSaveReq req) {

    }

    @Override
    public BaseUserInfoDTO getAndUpdateUserIpInfoBySessionId(String session, String clientIp) {
        return null;
    }

    @Override
    public SimpleUserInfoDTO querySimpleUserInfo(Long userId) {
        return null;
    }

    @Override
    public BaseUserInfoDTO queryBasicUserInfo(Long userId) {
        return null;
    }

    @Override
    public List<SimpleUserInfoDTO> batchQuerySimpleUserInfo(Collection<Long> userIds) {
        return List.of();
    }

    @Override
    public List<BaseUserInfoDTO> batchQueryBasicUserInfo(Collection<Long> userIds) {
        return List.of();
    }

    @Override
    public UserStatisticInfoDTO queryUserInfoWithStatistic(Long userId) {
        return null;
    }

    @Override
    public Long getUserCount() {
        return 0L;
    }

    @Override
    public void bindUserInfo(UserPwdLoginReq loginReq) {

    }
}
