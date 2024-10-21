package com.levent.api.model.exception;

import com.levent.api.model.vo.constants.StatusEnum;

/**
 * 异常工具类
 */
public class ExceptionUtil {

    public static ForumException of(StatusEnum status, Object... args) {
        return new ForumException(status, args);
    }

}