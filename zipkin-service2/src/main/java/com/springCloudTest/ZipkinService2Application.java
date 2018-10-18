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
public class ZipkinService2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinService2Application.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(ZipkinService2Application.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @GetMapping("/info")
    public String info() {
        log.info("calling zipKin2");
        return "I am zipKin2";
    }

    @GetMapping("/zipKin2")
    public String zipKin1() {
        log.info("I am zipKin2, call zipKin1");
        return restTemplate.getForObject("http://localhost:8081/info", String.class);
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
