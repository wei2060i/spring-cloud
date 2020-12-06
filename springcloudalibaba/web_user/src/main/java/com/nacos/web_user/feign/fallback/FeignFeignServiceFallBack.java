package com.nacos.web_user.feign.fallback;

import com.nacos.web_user.feign.IOrderFeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignFeignServiceFallBack implements IOrderFeignService {
    @Override
    public String hello() {
        return "服务调用false,稍后再试";
    }
}
