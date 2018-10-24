package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-24
 */


// FeignClient=服务名,[Get/Post]Mapping=服务方法,RequestParam服务参数,三者不可缺
@FeignClient("my-first-consul-service")
@Component
public interface FeignService {
    @RequestMapping(value = "/hello")
    public String hello(); // 如果有参数, 必须用RequestParam注解

}
