package com.qibria.cloud.filter;

import com.cloud.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyGateWayLogFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(MyGateWayLogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("--> start time: [{}]",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        queryParams.forEach((k, v) -> logger.info("key: {} || value: {}",k,v));

        String id = exchange.getRequest().getQueryParams().getFirst("id");
        if (id == null) {
            logger.error("请求参数id为空, 非法用户༼ つ ◕_◕ ༽つ");
            logger.info("<-- end time: [{}]",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //自定义返回封装对象
            CommonResult<String> data = new CommonResult<>(400,"请求参数id为空, 非法用户༼ つ ◕_◕ ༽つ",null);
            ServerHttpResponse response = exchange.getResponse();
            DataBuffer wrap = response.bufferFactory().wrap(data.toString().getBytes());
            response.setStatusCode(HttpStatus.BAD_GATEWAY);
            return response.writeWith(Mono.just(wrap));
        }
        logger.info("<-- end time: [{}]",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
