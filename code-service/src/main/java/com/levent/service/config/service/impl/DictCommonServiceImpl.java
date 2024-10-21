package com.levent.service.config.service.impl;

import com.levent.service.config.service.DictCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-21
 * @Description: 字典服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class DictCommonServiceImpl implements DictCommonService {
    @Override
    public Map<String, Object> getDict() {
        return Map.of();
    }
}
