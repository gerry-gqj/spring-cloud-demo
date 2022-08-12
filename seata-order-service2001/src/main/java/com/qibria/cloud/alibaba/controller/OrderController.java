package com.qibria.cloud.alibaba.controller;

import com.cloud.vo.CommonResult;
import com.qibria.cloud.alibaba.domain.Order;
import com.qibria.cloud.alibaba.service.OrderService;
import com.qibria.cloud.alibaba.service.feign.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}