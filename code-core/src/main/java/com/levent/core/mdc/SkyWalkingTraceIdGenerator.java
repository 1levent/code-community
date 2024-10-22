package com.levent.core.mdc;

import com.google.common.base.Joiner;

import java.util.UUID;

/**
 * SkyWalking的traceId生成策略
 * 设计思想主要是生成一个既唯一又能包含一些上下文信息的 traceid，
 * 帮助我们更好地追踪和理解分布式系统中的请求执行路径。
 */
public class SkyWalkingTraceIdGenerator {

    private static final String PROCESS_ID = UUID.randomUUID().toString().replaceAll("-", "");
    private static final ThreadLocal<IDContext> THREAD_ID_SEQUENCE = ThreadLocal.withInitial(
            () -> new IDContext(System.currentTimeMillis(), (short) 0));

    private SkyWalkingTraceIdGenerator() {
    }

    /**
     * Generate a new id, combined by three parts.
     * <p>
     * The first one represents application instance id.
     * <p>
     * The second one represents thread id.
     * <p>
     * The third one also has two parts, 1) a timestamp, measured in milliseconds 2) a seq, in current thread, between
     * 0(included) and 9999(included)
     *
     * @return unique id to represent a trace or segment
     */
    public static String generate() {
        return Joiner.on(".").join(
                PROCESS_ID,
                String.valueOf(Thread.currentThread().getId()),
                String.valueOf(THREAD_ID_SEQUENCE.get().nextSeq())
        );
    }

    /**
     * id生成器上下文
     */
    private static class IDContext {
        //设置最大请求序列号
        private static final int MAX_SEQ = 10_000;
        //时间戳
        private long lastTimestamp;
        //线程请求序列号
        private short threadSeq;

        // Just for considering time-shift-back only.
        //记录了上一次系统时间发生回拨时的时间戳
        private long lastShiftTimestamp;
        private int lastShiftValue;

        private IDContext(long lastTimestamp, short threadSeq) {
            this.lastTimestamp = lastTimestamp;
            this.threadSeq = threadSeq;
        }

        private long nextSeq() {
            return timestamp() * 10000 + nextThreadSeq();
        }

        /**
         * 获取时间戳
         * @return
         */
        private long timestamp() {
            long currentTimeMillis = System.currentTimeMillis();
            //如果发生了时间回拨
            if (currentTimeMillis < lastTimestamp) {
                // Just for considering time-shift-back by Ops or OS. @hanahmily 's suggestion.
                //当系统时间发生回拨时，lastShiftValue 被用来替代当前时间戳，以确保生成的时间戳仍然单调递增
                if (lastShiftTimestamp != currentTimeMillis) {
                    lastShiftValue++;
                    lastShiftTimestamp = currentTimeMillis;
                }
                return lastShiftValue;
            } else {
                lastTimestamp = currentTimeMillis;
                return lastTimestamp;
            }
        }

        private short nextThreadSeq() {
            if (threadSeq == MAX_SEQ) {
                threadSeq = 0;
            }
            return threadSeq++;
        }
    }
}