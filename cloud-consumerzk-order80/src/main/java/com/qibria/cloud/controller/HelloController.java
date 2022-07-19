package com.qibria.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;


    @RequestMapping(value = "/payment/zk")
    public String paymentZk() {
        return restTemplate.getForObject("/payment/zk",String.class);
    }

}
