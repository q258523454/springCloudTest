package com.springCloudTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulCloudApplication.class, args);
	}
    @GetMapping(value = "/hello")
    public String hello() {
        return "My First Consul.";
    }

}
