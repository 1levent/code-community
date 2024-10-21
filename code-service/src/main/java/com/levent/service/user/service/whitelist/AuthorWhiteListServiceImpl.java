package com.levent.service.user.service.whitelist;

import com.levent.api.model.vo.user.dto.BaseUserInfoDTO;
import com.levent.service.user.service.AuthorWhiteListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-20
 * @Description: 作者白名单服务
 * @Version: 1.0
 */
@Slf4j
@Service
public class AuthorWhiteListServiceImpl implements AuthorWhiteListService {
    @Override
    public boolean authorInArticleWhiteList(Long authorId) {
        return false;
    }

    @Override
    public List<BaseUserInfoDTO> queryAllArticleWhiteListAuthors() {
        return List.of();
    }

    @Override
    public void addAuthor2ArticleWhitList(Long userId) {

    }

    @Override
    public void removeAuthorFromArticleWhiteList(Long userId) {

    }
}
