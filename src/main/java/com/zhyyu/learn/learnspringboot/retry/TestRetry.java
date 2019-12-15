package com.zhyyu.learn.learnspringboot.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/12/15 10:55
 */
//@Component
public class TestRetry implements CommandLineRunner {

    @Autowired
    private HelloService helloService;

    @Override
    public void run(String... args) throws Exception {
        try {
            helloService.hello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
