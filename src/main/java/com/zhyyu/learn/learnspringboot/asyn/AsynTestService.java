package com.zhyyu.learn.learnspringboot.asyn;

import java.util.concurrent.Future;

/**
 * @author juror
 * @datatime 2019/12/30 15:15
 */
public interface AsynTestService {

    void synHello();

    /*
    @Async 注解亦可放在实现类
     */
//    @Async
    void asynHello();

    void asynHelloThrowEx(int i);

//    @Async
    String asynHelloRet();

//    @Async
    Future<String> asynHelloRet2();

}
