package com.funcionaenmimaquina.conditionalonproperty.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.funcionaenmimaquina.conditionalonproperty.MessageService;

@Service
@ConditionalOnProperty(name = "configuration.smsMessageEnabled", havingValue = "true")
public class SmsMessageServiceImpl implements MessageService{

    private static final Logger log = LoggerFactory.getLogger(SmsMessageServiceImpl.class);

    @Override
    public void sendMessage(String message) {
        log.info("Sending SMS message: {}",message);
    }
    
}
