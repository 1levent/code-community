package com.levent.service.config.service.impl;

import com.levent.api.model.enums.ConfigTypeEnum;
import com.levent.api.model.vo.banner.dto.ConfigDTO;
import com.levent.service.config.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-21
 * @Description: banner服务接口
 * @Version: 1.0
 */
@Slf4j
@Service
public class ConfigServiceImpl implements ConfigService {
    @Override
    public List<ConfigDTO> getConfigList(ConfigTypeEnum configTypeEnum) {
        return List.of();
    }

    @Override
    public void updateVisit(long configId, String extra) {

    }
}
