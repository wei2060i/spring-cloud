package com.nacos.web_user.feign;

import com.nacos.web_user.feign.fallback.FeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Wei
 */
@FeignClient(value = "web-order", fallback = FeignServiceFallBack.class)
public interface IOrderFeignService {

    @GetMapping("order/hello")
    String hello();

}
