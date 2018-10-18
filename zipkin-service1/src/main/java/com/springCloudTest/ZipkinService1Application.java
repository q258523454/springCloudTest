package com.springCloudTest;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinService1Application {


    private static final Logger log = LoggerFactory.getLogger(ZipkinService1Application.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ZipkinService1Application.class, args);
    }

    @GetMapping("/info")
    public String info() {
        log.info("I am zipkin1");
        return "I am zipkin1";
    }

    @GetMapping("/zipKin1")
    public String zipKin1() {
        log.info("I am zipKin1, call zipKin2");
        return restTemplate.getForObject("http://localhost:8082/info", String.class);
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
