package com.nacos.web_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.nacos.web_user.feign"})
@SpringBootApplication
@EnableDiscoveryClient
public class WebUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebUserApplication.class, args);
    }

}
