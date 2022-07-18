package com.qibria.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "payment/consul")
    public String paymentConsul() {
        return "hello consul---" + port +"---"+ UUID.randomUUID();
    }


}
