package com.qibria.cloud.alibaba.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private static final String TAG = "RestTemplateConfig";
    private final Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);

    @Value("${restTemplate.service-url.nacos-user-service}")
    private String nacosServer;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        logger.info("nacosServer:[{}]", nacosServer);
        return restTemplateBuilder.rootUri(nacosServer).build();
    }
}
