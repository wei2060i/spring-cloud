package com.wechart_user.feginservice.fallback;

import com.wechart_user.feginservice.IFeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallBack implements IFeignService {

    @Override
    public String hello() {
        return "服务调用false,稍后再试";
    }

    @Override
    public String getParam(String id) {
        return id + "服务调用false,稍后再试";
    }
}
