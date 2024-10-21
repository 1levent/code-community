package com.levent.service.config.service.impl;

import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.config.GlobalConfigReq;
import com.levent.api.model.vo.config.SearchGlobalConfigReq;
import com.levent.api.model.vo.config.dto.GlobalConfigDTO;
import com.levent.service.config.service.GlobalConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-21
 * @Description: 全局配置服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class GlobalConfigServiceImpl implements GlobalConfigService {
    @Override
    public PageVo<GlobalConfigDTO> getList(SearchGlobalConfigReq req) {
        return null;
    }

    @Override
    public void save(GlobalConfigReq req) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void addSensitiveWhiteWord(String word) {

    }
}
