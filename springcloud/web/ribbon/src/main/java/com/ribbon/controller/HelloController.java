package com.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("ribbon")
    @HystrixCommand(defaultFallback = "fallBack")
    public String hello() {
        System.out.println(Thread.currentThread().getName() + "ribbon被调用");
        /**
         * 根据应用名称FEGIN-USER 调用微服务
         * 启动类  注入RestTemplate时 加上 @LoadBalanced 自动负载均衡调用
         */
        return restTemplate.getForObject("http://FEGIN-USER/user/1", String.class);
    }

    /**
     * 服务降级方法,必须和说明的方法返回值一样
     * @return
     */
    public String fallBack() {
        return "调用资源失败";
    }

    @GetMapping("testId/{id}")
    public String getParam(@PathVariable String id) {
        return id;
    }
}
