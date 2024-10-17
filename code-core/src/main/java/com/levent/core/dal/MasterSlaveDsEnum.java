package com.levent.core.dal;

/**
 * @author levent
 * @description: 主从数据源的枚举类
 * @date
 */
public enum MasterSlaveDsEnum implements DS {
    /**
     * master主数据源类型
     */
    MASTER,
    /**
     * slave从数据源类型
     */
    SLAVE;
}
