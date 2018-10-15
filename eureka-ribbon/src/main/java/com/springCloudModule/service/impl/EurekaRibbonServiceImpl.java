package com.springCloudModule.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springCloudModule.service.EurekaRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-12
 */

@Service
public class EurekaRibbonServiceImpl implements EurekaRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "hystrixError") //加上断路器功能, 指定发生错误时回调的方法, 注意形参保持一致
    public String ribbonTest(String name) {
        return restTemplate.getForObject("http://eureka-service/getServicePort?name=" + name, String.class);
    }

    public String hystrixError(String name) {
        return "Sorry:" + name + ", Hystrix Occur Error.";
    }

}
