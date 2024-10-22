package com.levent.web.component;

import com.levent.core.util.MapUtils;
import com.levent.web.global.GlobalInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;
/**
 * 模板引擎辅助类
 */
@Component
public class TemplateEngineHelper {
    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private GlobalInitService globalInitService;

    /**
     * 模板渲染
     *
     * @param template
     * @param attrName
     * @param attrVal
     * @param <T>
     * @return
     */
    public <T> String render(String template, String attrName, T attrVal) {
        Context context = new Context();
        context.setVariable(attrName, attrVal);
        context.setVariable("global", globalInitService.globalAttr());
        return springTemplateEngine.process(template, context);
    }

    public <T> String render(String template, T attr) {
        return render(template, "vo", attr);
    }

    /**
     * 模板渲染，传参属性放在vo包装类下
     *
     * @param template 模板
     * @param second   实际的data属性
     * @param val      传参
     * @param <T>
     * @return
     */
    public <T> String renderToVo(String template, String second, T val) {
        Context context = new Context();
        context.setVariable("vo", MapUtils.create(second, val));
        return springTemplateEngine.process(template, context);
    }
}