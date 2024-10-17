package com.levent.core.dal;

import java.util.function.Supplier;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-11
 * @Description: 手动指定数据源的方法
 * @Version: 1.0
 */
public class DsSelectExecutor {

    /**
     * 提交一个任务，并指定数据源
     * @param ds
     * @param supplier
     * @return
     * @param <T>
     */
    public static <T> T submit(DS ds, Supplier<T> supplier){
        DsContextHolder.set(ds);
        try{
            //调用实际的业务处理逻辑，获取结果
            return supplier.get();
        }finally{
            DsContextHolder.reset();
        }
    }

    /**
     * 执行任务，无返回结果
     * @param ds
     * @param runnable
     */
    public static void excute(DS ds, Runnable runnable){
        DsContextHolder.set(ds);
        try{
            //调用实际的业务处理逻辑，获取结果
            runnable.run();
        }finally{
            DsContextHolder.reset();
        }
    }
}
