package com.levent.service.user.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: levent
 */
@Data
@TableName("people")
public class People {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}