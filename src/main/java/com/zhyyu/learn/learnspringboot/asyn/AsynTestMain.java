package com.zhyyu.learn.learnspringboot.asyn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author juror
 * @datatime 2019/12/30 15:19
 */
//@Component
public class AsynTestMain implements CommandLineRunner {

    @Autowired
    private AsynTestService asynTestService;

    @Override
    public void run(String... args) throws Exception {
        /**
         * synHello: main
         * asynHello: task-1
         * aysnHelloRet: task-2
         * null
         * aysnHelloRet2: task-3
         * aysnHelloRet2
         */

        asynTestService.synHello();
        asynTestService.asynHello();

        // 返回null
        String s = asynTestService.asynHelloRet();
        System.out.println(s);

        // 返回futuer
        Future<String> stringFuture = asynTestService.asynHelloRet2();
        System.out.println(stringFuture.get());

        // ex
        asynTestService.asynHelloThrowEx(10);
    }

}
