package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class FallBackController {
    /**
     *
     * @return
     */
    @GetMapping("HystrixFallBack")
    public String getHystrixFallBack() {
        return "gatewayHystrixFallBack";
    }
}
