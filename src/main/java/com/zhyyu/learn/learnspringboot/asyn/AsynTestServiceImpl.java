package com.zhyyu.learn.learnspringboot.asyn;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author juror
 * @datatime 2019/12/30 15:17
 */
@Service
public class AsynTestServiceImpl implements AsynTestService {


    @Override
    public void synHello() {
        System.out.println("synHello: " + Thread.currentThread().getName());
    }

    @Async
    @Override
    public void asynHello() {
        System.out.println("asynHello: " + Thread.currentThread().getName());
    }

    @Async
    @Override
    public void asynHelloThrowEx(int i) {
        System.out.println("asynHelloThrowEx: " + Thread.currentThread().getName());
        i = 1 / 0;
    }

    @Async("costomExectuor")
    @Override
    public String asynHelloRet() {
        System.out.println("aysnHelloRet: " + Thread.currentThread().getName());
        return "aysnHelloRet";
    }

    @Async
    @Override
    public Future<String> asynHelloRet2() {
        System.out.println("aysnHelloRet2: " + Thread.currentThread().getName());
        return new AsyncResult<>("aysnHelloRet2");
    }


}
