package com.zhyyu.learn.learnspringboot.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

/**
 * @author juror
 * @datatime 2019/12/15 10:48
 */
public interface HelloService {

    @Retryable(
            value = { RuntimeException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 3000))
    void hello();

}
