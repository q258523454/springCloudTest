package com.springCloudTest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@RestController
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }


    @Value("${server.port}")
    String port;

    /**
     * 访问步骤:
     * 1: http://localhost:8777/hystrixDashboard?name=123
     * 2: http://localhost:8777/actuator/hystrix.stream
     * 3: http://localhost:8777/hystrix
     *  3.1: 输入断路数据源: http://localhost:8777/actuator/hystrix.stream
     *  3.2: 输入延迟检测: 1~n ms
     *  3.3: 输入application name
     */

    @RequestMapping("/hystrixDashboard")
    @HystrixCommand(fallbackMethod = "errorOccur")
    public String hystrixDashboard(@RequestParam(value = "name", defaultValue = "defaultName") String name) {
        return "name:" + name + " ,port:" + port;
    }

    public String errorOccur(String name) {
        return name + ",sorry,errorOccur!";
    }
}
