package com.levent.service.user.repository.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.levent.api.model.vo.PageParam;
import com.levent.api.model.vo.user.dto.ZsxqUserInfoDTO;
import com.levent.service.user.repository.entity.UserAiDO;
import com.levent.service.user.repository.params.SearchZsxqWhiteParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ai用户登录mapper接口
 */
public interface UserAiMapper extends BaseMapper<UserAiDO> {

    Long countZsxqUsersByParams(@Param("searchParams") SearchZsxqWhiteParams params);

    List<ZsxqUserInfoDTO> listZsxqUsersByParams(@Param("searchParams") SearchZsxqWhiteParams params,
                                                @Param("pageParam") PageParam newPageInstance);
}
