package com.levent.web.demo;

import com.levent.service.demo.repository.entity.People;
import com.levent.service.demo.repository.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-17
 * @Description: test
 * @Version: 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private PeopleMapper peopleMapper;

    @RequestMapping("/List")
    public List<People> getPeopleList(){
        return peopleMapper.selectList(null);
    }
}
