package com.levent.core.mdc;

import org.slf4j.MDC;

/**
 * @author levent
 * mdc工具类，主要用于记录traceId,
 * 在高并发环境中频繁访问 MDC 可能会影响性能
 */
public class MdcUtil {
    public static final String TRACE_ID_KEY = "traceId";

    public static void add(String key, String val) {
        //MDC 是一个线程绑定的 Map，允许开发人员在日志消息中插入额外的上下文信息
        MDC.put(key, val);
    }

    public static void addTraceId() {
        // traceId的生成规则，提供了两种生成策略，可以使用自定义的也可以使用SkyWalking;
        MDC.put(TRACE_ID_KEY, SelfTraceIdGenerator.generate());
    }

    public static String getTraceId() {
        return MDC.get(TRACE_ID_KEY);
    }

    public static void reset() {
        String traceId = MDC.get(TRACE_ID_KEY);
        MDC.clear();
        MDC.put(TRACE_ID_KEY, traceId);
    }

    public static void clear() {
        MDC.clear();
    }
}