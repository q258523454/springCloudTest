package com.springCloudModule.controller;

import com.springCloudModule.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-12
 */

@RestController
public class Test {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/test", produces = "application/json; charset=UTF-8")
    public String test(String name) {
        return testService.ribbonTest(name);
    }
}
