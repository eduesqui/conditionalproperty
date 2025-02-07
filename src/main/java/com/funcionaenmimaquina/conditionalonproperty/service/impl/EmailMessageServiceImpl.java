package com.funcionaenmimaquina.conditionalonproperty.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.funcionaenmimaquina.conditionalonproperty.MessageService;

@Service
@ConditionalOnProperty(name = "configuration.emailMessageEnabled", havingValue = "true")
public class EmailMessageServiceImpl implements MessageService{

    private static final Logger log = LoggerFactory.getLogger(EmailMessageServiceImpl.class);

    @Override
    public void sendMessage(String message) {
       log.info("Sending Email message: {}",message);
    }

}
