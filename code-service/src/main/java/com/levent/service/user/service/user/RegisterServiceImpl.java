package com.levent.service.user.service.user;

import com.levent.api.model.vo.user.UserPwdLoginReq;
import com.levent.service.user.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 用户注册服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {

    @Override
    public Long registerByUserNameAndPassword(UserPwdLoginReq loginReq) {
        return 0L;
    }

    @Override
    public Long registerByWechat(String thirdAccount) {
        return 0L;
    }
}





