package com.levent.service.user.service.user;

import com.levent.api.model.vo.user.UserPwdLoginReq;
import com.levent.service.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 登录服务
*@Version: 1.0
*/
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Long autoRegisterWxUserInfo(String uuid) {
        return 0L;
    }

    @Override
    public void logout(String session) {

    }

    @Override
    public String loginByWx(Long userId) {
        return "";
    }

    @Override
    public String loginByUserPwd(String username, String password) {
        return "";
    }

    @Override
    public String registerByUserPwd(UserPwdLoginReq loginReq) {
        return "";
    }
}
