package com.zhyyu.learn.learnspringboot.starter;

//import com.zhyyu.learn.springboot.api.testautoconfig.MyAutoConfigedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/9/6 15:29
 */
//@Component
public class CustomizeStarterTest implements CommandLineRunner {

//    @Autowired
//    private MyAutoConfigedBean myAutoConfigedBean;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
//        String res = myAutoConfigedBean.doSomething();
//        System.out.println(res);

        Object myAutoConfigedBean = applicationContext.getBean("myAutoConfigedBean");
        System.out.println(myAutoConfigedBean);
    }
}
