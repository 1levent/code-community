package com.levent.api.model.enums.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 站点统计类型枚举
 *
 * @author levent
 * @date 2024/8/22
 */
@AllArgsConstructor
@Getter
public enum SiteVisitStatisticsEnum {
    PV(1, "浏览量"),
    UV(2, "独立访客"),
    VV(3, "访问次数"),
    ;

    private int type;
    private String desc;
}
