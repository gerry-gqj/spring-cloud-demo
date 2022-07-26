package com.qibria.cloud.service.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({Sink.class})
public class ReceiveMessageListener {

    private final Logger logger = LoggerFactory.getLogger(ReceiveMessageListener.class);

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        logger.info("server port:[{}]", serverPort);
        logger.info("message:[{}]", message);
        logger.info("消息内容 message payload: [{}]", message.getPayload());
    }

}
