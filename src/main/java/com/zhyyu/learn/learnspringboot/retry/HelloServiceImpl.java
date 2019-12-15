package com.zhyyu.learn.learnspringboot.retry;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author juror
 * @datatime 2019/12/15 10:54
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void hello() {
        System.out.println("hello " + new Date());
        int i = 1 / 0;
    }

}
