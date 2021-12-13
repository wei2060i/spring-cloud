package com.nacos.web_order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Wei
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("hello")
    private String hello() {
        System.out.println("我被调用了");
        //int i = 1 /0;
        return "hello,i am web_order";
    }

}
