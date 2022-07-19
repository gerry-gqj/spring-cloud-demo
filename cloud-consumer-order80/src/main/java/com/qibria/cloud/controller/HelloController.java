package com.qibria.cloud.controller;

import com.cloud.vo.CommonResult;
import com.cloud.vo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    private final RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    public HelloController(RestTemplate template) {
        this.restTemplate = template;
    }

    @GetMapping("hello")
    public CommonResult hello(){
        return restTemplate.getForObject("/hello", CommonResult.class);
    }

    @GetMapping("hello/get")
    public CommonResult<Payment> helloGet(Payment payment){
        return restTemplate.getForObject("/hello/get?id={id}&serial={serial}",
                CommonResult.class, 10, "hello get");
    }

    @GetMapping("hello/post")
    public CommonResult<Payment> helloPost(Payment payment){
        return restTemplate.postForObject("/hello/post", payment, CommonResult.class);
    }

}
