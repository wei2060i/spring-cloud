package com.nacos.web_user.feign;

import com.nacos.web_user.feign.fallback.FeignFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "web-order")
public interface IOrderFeignService {

    @GetMapping("order/hello")
    String hello();

}
