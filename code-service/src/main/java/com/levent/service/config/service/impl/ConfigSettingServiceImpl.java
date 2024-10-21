package com.levent.service.config.service.impl;

import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.banner.ConfigReq;
import com.levent.api.model.vo.banner.SearchConfigReq;
import com.levent.api.model.vo.banner.dto.ConfigDTO;
import com.levent.service.config.service.ConfigSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-21
 * @Description: banner后台服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class ConfigSettingServiceImpl implements ConfigSettingService {
    @Override
    public void saveConfig(ConfigReq configReq) {

    }

    @Override
    public void deleteConfig(Integer bannerId) {

    }

    @Override
    public void operateConfig(Integer bannerId, Integer pushStatus) {

    }

    @Override
    public PageVo<ConfigDTO> getConfigList(SearchConfigReq params) {
        return null;
    }

    @Override
    public PageVo<ConfigDTO> getNoticeList(PageParam pageParam) {
        return null;
    }
}
