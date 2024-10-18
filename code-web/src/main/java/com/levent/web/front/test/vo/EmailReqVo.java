package com.levent.web.front.test.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailReqVo implements Serializable {
    private static final long serialVersionUID = -8560585303684975482L;

    private String to;

    private String title;

    private String content;

}
