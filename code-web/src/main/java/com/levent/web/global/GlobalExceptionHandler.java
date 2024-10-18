package com.levent.web.global;

import com.levent.api.model.exception.ForumAdviceException;
import com.levent.api.model.vo.ResVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author levent
 * @Description: 全局异常处理
 * @RestControllerAdvice 是一个特殊的 @ControllerAdvice注解，
 * 适用于处理 RESTful API 异常的情况。
 * 这意味着它将用于处理来自带有 @RestController注解的控制器抛出的异常。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    //表示它将处理 ForumAdviceException 类型的异常
    @ExceptionHandler(value = ForumAdviceException.class)
    public ResVo<String> handleForumAdviceException(ForumAdviceException e) {
        return ResVo.fail(e.getStatus());
    }
}