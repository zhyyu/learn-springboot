package com.zhyyu.learn.learnspringboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringbootApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEnv() {
        Assert.assertEquals(Arrays.asList(environment.getDefaultProfiles()).get(0), "default");
    }

}
