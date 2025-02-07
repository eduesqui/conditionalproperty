package com.funcionaenmimaquina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.funcionaenmimaquina.conditionalonproperty.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ConditionalOnProperty {

  private static final Logger logger = LoggerFactory.getLogger(ConditionalOnProperty.class);

  @Autowired
  MessageService messageService;

  public static void main(String[] args) {
    SpringApplication.run(ConditionalOnProperty.class, args);
   
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReady() {
    logger.info("Start");
    messageService.sendMessage("Any Text ");
    logger.info("Finish");
  }

}
