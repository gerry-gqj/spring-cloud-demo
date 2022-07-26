package com.qibria.cloud.alibaba.controller;

import com.cloud.vo.CommonResult;
import com.cloud.vo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id) {

        String message = "nacos registry, server port:" + serverPort + "\t-->id:" + id;
        CommonResult result = new CommonResult<>(200,message);
        return result;
    }
}
