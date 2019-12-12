package com.zhyyu.learn.learnspringboot.controller;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author juror
 * @datatime 2019/12/11 10:58
 */
@RestController
@RequestMapping("bindingResult")
public class BindingResultTest {

    @RequestMapping("testBindingResult")
    public String testBindingResult(@Valid MyObj obj, BindingResult result) {
        List<ObjectError> allErrors = result.getAllErrors();
        allErrors.forEach(objectError -> {
            System.out.println(objectError.getCode());
            System.out.println(objectError.getDefaultMessage());
        });
        return "hello";
    }

    @Data
    private static class MyObj {
        @NotBlank(message = "NotBlank.value1")
        private String value1;

        @NotNull(message = "NotNull.value2")
        private String value2;
    }

}
