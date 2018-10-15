package com.springCloudModule.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-15
 */


@FeignClient(value = "eureka-service")
@Component
public interface FeignService {

    // @RequestParam 这个注解必须有, 不然报错
    @GetMapping(value = "/getServicePort")
    String callFeign(@RequestParam(value = "name") String name);
}
