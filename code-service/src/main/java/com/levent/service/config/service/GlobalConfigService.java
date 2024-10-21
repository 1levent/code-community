package com.levent.service.config.service;

import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.config.GlobalConfigReq;
import com.levent.api.model.vo.config.SearchGlobalConfigReq;
import com.levent.api.model.vo.config.dto.GlobalConfigDTO;

/**
 * 全局配置服务
 */
public interface GlobalConfigService {
    PageVo<GlobalConfigDTO> getList(SearchGlobalConfigReq req);

    void save(GlobalConfigReq req);

    void delete(Long id);

    /**
     * 添加敏感词白名单
     *
     * @param word
     */
    void addSensitiveWhiteWord(String word);
}