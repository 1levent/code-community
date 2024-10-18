package com.levent.api.model.exception;

import com.levent.api.model.vo.Status;
import com.levent.api.model.vo.constants.StatusEnum;
import lombok.Getter;

/**
 * @author levent
 * @date 2024/10/18
 * @Description: 业务异常
 */
public class ForumException extends RuntimeException {
    @Getter
    private Status status;

    public ForumException(Status status) {
        this.status = status;
    }

    public ForumException(int code, String msg) {
        this.status = Status.newStatus(code, msg);
    }

    public ForumException(StatusEnum statusEnum, Object... args) {
        this.status = Status.newStatus(statusEnum, args);
    }

}