package com.zhyyu.learn.learnspringboot.asyn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author juror
 * @datatime 2019/12/30 15:36
 */
@Slf4j
@Configuration
public class AsynThreadPoolConfig {

    @Bean
    public Executor costomExectuor() {
        return Executors.newFixedThreadPool(10);
    }

}
