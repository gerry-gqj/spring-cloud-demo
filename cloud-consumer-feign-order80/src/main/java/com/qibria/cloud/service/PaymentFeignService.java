package com.qibria.cloud.service;

import com.cloud.vo.CommonResult;
import com.cloud.vo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/hello")
    CommonResult<Payment> hello();

}
