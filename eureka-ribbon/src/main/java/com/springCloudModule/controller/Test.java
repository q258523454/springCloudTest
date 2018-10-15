package com.springCloudModule.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springCloudModule.service.EurekaRibbonService;
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
    private EurekaRibbonService eurekaRibbonService;

    @GetMapping(value = "/eurekaRibbon", produces = "application/json; charset=UTF-8")
    public String test(String name) {
        return JSONObject.toJSONString(eurekaRibbonService.ribbonTest(name));
    }
}
