package com.qibria.cloud.controller;

import com.cloud.vo.CommonResult;
import com.cloud.vo.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("hello")
    public CommonResult hello() {
       return new CommonResult<>(200, "hello: " + port +"\t-->"+ UUID.randomUUID());
    }

    @GetMapping("hello/get")
    public CommonResult<Payment> helloGet(Payment payment){
       return new CommonResult<>(200, "hello get: " + port, payment);
    }

    @PostMapping("hello/post")
    public CommonResult<Payment> helloPost(@RequestBody Payment payment){
       return new CommonResult<>(200, "hello post: " + port, payment);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: "+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
