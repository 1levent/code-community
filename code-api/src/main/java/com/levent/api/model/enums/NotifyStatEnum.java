package com.levent.api.model.enums;

import lombok.Getter;

/**
 * 通知状态
 * @author levent
 * @date 2024/9/3
 */
@Getter
public enum NotifyStatEnum {
    UNREAD(0, "未读"),
    READ(1, "已读");


    private int stat;
    private String msg;

    NotifyStatEnum(int type, String msg) {
        this.stat = type;
        this.msg = msg;
    }
}
