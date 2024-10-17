package com.levent.web.test;

import com.levent.web.QuickStart;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author levent
 */
@Slf4j
@SpringBootTest(classes = QuickStart.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicTest {
}