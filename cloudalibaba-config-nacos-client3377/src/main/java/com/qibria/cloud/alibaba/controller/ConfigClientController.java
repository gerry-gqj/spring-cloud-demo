package com.qibria.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)//支持Nacos的动态刷新功能。
@RefreshScope//支持Nacos的动态刷新功能。
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${spring.profiles.active}")
    private String profiles;


    @GetMapping("/config/info")
    public String getConfigInfo() {
        return "profiles active: "+ profiles +
                "\n\rconfig info: "+ configInfo;
    }
}
