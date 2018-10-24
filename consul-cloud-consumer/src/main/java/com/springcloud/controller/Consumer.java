package com.springcloud.controller;

import com.springcloud.service.FeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-24
 */

@RestController
public class Consumer {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/getServices")
    public Object getServices() {
        return discoveryClient.getInstances("my-first-consul-service");
    }

    // 轮询的选择同服务(来自不同的客户注册中心,IP不同)
    @GetMapping(value = "/chooseService")
    public Object chooseService() {
        return loadBalancerClient.choose("my-first-consul-service").getUri().toString();
    }

    // -------------------------- ribbon --------------------------
    @GetMapping(value = "/ribbon-call")
    public String ribbonCall() {
        String method = "hello";
        return restTemplate.getForEntity("http://my-first-consul-service/" + method, String.class).getBody();
    }

    // -------------------------- Feign --------------------------
    @GetMapping(value = "/feign-call")
    public String feignCall() {
        return feignService.hello();
    }

}
