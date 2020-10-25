package com.wechart_user.feginservice;

import com.wechart_user.feginservice.fallback.FeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 写了服务降级方法(fallback),接口上面不能一定不能写 @RequestMapping
 */
@FeignClient(value = "service-ribbon", fallback = FeignServiceFallBack.class)
public interface IFeignService {

    @GetMapping("/hello/ribbon")
    String hello();

    @GetMapping("/hello/testId/{id}")
    String getParam(@PathVariable String id);

}
