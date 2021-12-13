package com.nacos.web_user.controller;

import com.nacos.web_user.service.IUserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Wei
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping
    private String hello() {
        return userService.hello();
    }

    @GetMapping("list")
    private String hello2() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "listA";
    }

    @GetMapping("list2")
    private String hello3() {
        return "listB";
    }

}
