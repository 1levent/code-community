package com.levent.service.user.service;



import com.levent.api.model.enums.user.UserAIStatEnum;
import com.levent.api.model.vo.PageVo;
import com.levent.api.model.vo.user.SearchZsxqUserReq;
import com.levent.api.model.vo.user.ZsxqUserPostReq;
import com.levent.api.model.vo.user.dto.ZsxqUserInfoDTO;

import java.util.List;

public interface ZsxqWhiteListService {
    PageVo<ZsxqUserInfoDTO> getList(SearchZsxqUserReq req);

    void operate(Long id, UserAIStatEnum operate);

    void update(ZsxqUserPostReq req);

    void batchOperate(List<Long> ids, UserAIStatEnum operate);

    void reset(Integer authorId);
}
