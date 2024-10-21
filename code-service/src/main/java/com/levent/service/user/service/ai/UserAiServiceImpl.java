package com.levent.service.user.service.ai;

import com.levent.api.model.enums.ai.AISourceEnum;
import com.levent.api.model.vo.chat.ChatItemVo;
import com.levent.api.model.vo.user.UserPwdLoginReq;
import com.levent.service.user.service.UserAiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 用户ai服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class UserAiServiceImpl implements UserAiService {
    @Override
    public void pushChatItem(AISourceEnum source, Long user, ChatItemVo item) {

    }

    @Override
    public int getMaxChatCnt(Long userId) {
        return 0;
    }

    @Override
    public void initOrUpdateAiInfo(UserPwdLoginReq loginReq) {

    }
}
