package com.springCloudModule.service;

import com.springCloudModule.util.HystrixErrorCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-15
 */

@FeignClient(value = "my-eureka-service", fallback = HystrixErrorCallBack.class)
public interface FeignService {

    // @RequestParam 这个注解必须有, 不然报错,FeignClient=服务名,GetMapping=服务方法,RequestParam服务参数,三者不可缺
    @GetMapping(value = "/getServicePort")
    String callFeign(@RequestParam(value = "name") String name);
}
