package com.qibria.cloud.controller;

import com.qibria.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("send")
    public String sendMessage(){
        return messageProvider.send();
    }


}
