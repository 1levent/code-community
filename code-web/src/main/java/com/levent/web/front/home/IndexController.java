package com.levent.web.front.home;

import com.levent.web.front.home.helper.IndexRecommendHelper;
import com.levent.web.front.home.vo.IndexVo;
import com.levent.web.global.BaseViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;

/**
 * @author levent
 * 指向首页
 */
@Controller
public class IndexController extends BaseViewController {
    @Resource
    private IndexRecommendHelper indexRecommendHelper;

    @GetMapping(path = {"/", "", "/index", "/login"})
    public String index(Model model, HttpServletRequest request) {
        String activeTab = request.getParameter("category");
        IndexVo vo = indexRecommendHelper.buildIndexVo(activeTab);
        model.addAttribute("vo", vo);
        return "views/home/index";
    }
}