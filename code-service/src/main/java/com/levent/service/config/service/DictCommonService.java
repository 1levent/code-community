package com.levent.service.config.service;

import java.util.Map;

/**
 * 字典服务
 */
public interface DictCommonService {

    /**
     * 获取字典值
     * @return
     */
    Map<String, Object> getDict();
}