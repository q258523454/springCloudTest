package com.springCloudModule.controller;

import com.alibaba.fastjson.JSONObject;
import com.springCloudModule.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-15
 */

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/callFeign")
    public String callFeign(String name) {
        return JSONObject.toJSONString(feignService.callFeign(name));
    }

}

