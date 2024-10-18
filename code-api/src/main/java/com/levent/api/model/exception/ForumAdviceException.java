package com.levent.api.model.exception;

import com.levent.api.model.vo.Status;
import com.levent.api.model.vo.constants.StatusEnum;
import lombok.Getter;

/**
 * @author levent
 * 业务异常
 */
public class ForumAdviceException extends RuntimeException {
    @Getter
    private Status status;

    public ForumAdviceException(Status status) {
        this.status = status;
    }

    public ForumAdviceException(int code, String msg) {
        this.status = Status.newStatus(code, msg);
    }

    public ForumAdviceException(StatusEnum statusEnum, Object... args) {
        this.status = Status.newStatus(statusEnum, args);
    }

}