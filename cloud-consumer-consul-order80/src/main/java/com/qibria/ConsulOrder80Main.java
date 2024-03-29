package com.qibria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrder80Main {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrder80Main.class, args);
    }

}
