package com.levent.core.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-18
 * @Description: 告警工具类
 * @Version: 1.0
 */
public class AlarmUtil extends AppenderBase<ILoggingEvent> {
    private static final long INTERVAL = 10 * 1000 * 60;
    private long lastAlarmTime = 0;
    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        if (canAlarm()) {
            EmailUtil.sendMail(iLoggingEvent.getLoggerName(),
                    SpringUtil.getConfig("alarm.user", "xhhuiblog@163.com"),
                    iLoggingEvent.getFormattedMessage());
        }
    }
    private boolean canAlarm() {
        // 做一个简单的频率过滤,一分钟内只允许发送一条报警
        long now = System.currentTimeMillis();
        if (now - lastAlarmTime >= INTERVAL) {
            lastAlarmTime = now;
            return true;
        } else {
            return false;
        }
    }
}
