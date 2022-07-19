package com.qibria.cloud.controller;

import com.cloud.vo.CommonResult;
import com.cloud.vo.Payment;
import com.qibria.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public CommonResult<Payment> hello(){
        return paymentFeignService.hello();
    }

}
