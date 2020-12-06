package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class GlobalGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("GlobalGateWayFilter----date:" + LocalDateTime.now());
        String name = exchange.getRequest().getQueryParams().getFirst("name");
//        if (name == null) {
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            //完成 离开
//            return exchange.getResponse().setComplete();
//        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器加载顺序,越小,优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
