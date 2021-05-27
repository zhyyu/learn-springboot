package com.zhyyu.learn.learnspringboot.controller;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.CallableWrapper;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Trace;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HelloService2 {

    @Trace
//    @Tag(key = "anno_tag1", value = "returnedObj")
    public String hello() {
//        ActiveSpan.tag("ActiveSpan_tag1", "ActiveSpan_tag1_val");
//        ActiveSpan.info("ActiveSpan_info_1");
        return "HelloService2 hello";
    }

    @Trace
    public String hello2() throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(CallableWrapper.of(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello2 asy ret";
            }
        }));

        new Thread(futureTask).start();

        return "HelloService2 hello2:" + futureTask.get();
    }

}
