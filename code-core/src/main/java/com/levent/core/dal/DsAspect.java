package com.levent.core.dal;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-10
 * @Description: 切面
 * @Version: 1.0
 */
@Aspect
public class DsAspect {
    /**
     * within: 匹配当前类中的所有方法（有注解的类）
     */
    @Pointcut("@annotation(com.levent.core.dal.DsAno) || @within(com.levent.core.dal.DsAno)")
    public void pointcut(){
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        DsAno ds = getDsAno(proceedingJoinPoint);
        try {
            if(ds!=null&& (StringUtils.isNotBlank(ds.ds())||ds.value()!=null)){
                //写入上下文
                DsContextHolder.set(StringUtils.isNoneBlank(ds.ds())?ds.ds():ds.value().name());
            }
            return proceedingJoinPoint.proceed();
        } finally {
            // 清空上下文信息
            if (ds != null) {
                DsContextHolder.reset();
            }
        }
    }

    /**
     * 获取注解,先获取方法上的注解，再获取类上的注解
     * @param proceedingJoinPoint
     * @return
     */
    public DsAno getDsAno(ProceedingJoinPoint proceedingJoinPoint) {
        //获取方法签名
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        DsAno ds = method.getAnnotation(DsAno.class);
        if (ds == null) {
            // 获取类上的注解
            ds = (DsAno) proceedingJoinPoint.getSignature().getDeclaringType().getAnnotation(DsAno.class);
        }
        return ds;
    }
}
