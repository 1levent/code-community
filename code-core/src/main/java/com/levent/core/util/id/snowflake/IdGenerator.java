package com.levent.core.util.id.snowflake;

/**
 * id生成器
 */
public interface IdGenerator {
    /**
     * 生成分布式id
     *
     * @return
     */
    Long nextId();
}