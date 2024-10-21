package com.levent.api.model.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录方式
 * @author levent
 * @date 2024/6/26
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
    /**
     * 微信登录
     */
    WECHAT(0),
    /**
     * 用户名+密码登录
     */
    USER_PWD(1),
    ;
    private int type;
}
