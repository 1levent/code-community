package com.levent.service.user.service.whitelist;

import com.levent.api.model.enums.user.UserAIStatEnum;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.user.SearchZsxqUserReq;
import com.levent.api.model.vo.user.ZsxqUserPostReq;
import com.levent.api.model.vo.user.dto.ZsxqUserInfoDTO;
import com.levent.service.user.service.ZsxqWhiteListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Author: guanxinyi
*@CreateTime: 2024-10-20
*@Description: 知识星球白名单服务
*@Version: 1.0
*/
@Slf4j
@Service
public class ZsxqWhiteListServiceImpl implements ZsxqWhiteListService {
    @Override
    public PageVo<ZsxqUserInfoDTO> getList(SearchZsxqUserReq req) {
        return null;
    }

    @Override
    public void operate(Long id, UserAIStatEnum operate) {

    }

    @Override
    public void update(ZsxqUserPostReq req) {

    }

    @Override
    public void batchOperate(List<Long> ids, UserAIStatEnum operate) {

    }

    @Override
    public void reset(Integer authorId) {

    }
}
