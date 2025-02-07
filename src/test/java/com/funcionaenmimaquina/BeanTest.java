package com.funcionaenmimaquina;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import com.funcionaenmimaquina.conditionalonproperty.service.impl.EmailMessageServiceImpl;
import com.funcionaenmimaquina.conditionalonproperty.service.impl.SmsMessageServiceImpl;
import com.funcionaenmimaquina.config.Config;

@EnableConfigurationProperties
@SpringBootTest
class BeanTest {

  
  private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
  .withUserConfiguration(BeanTest.class);


  @Test
  void testBean_HttpCodeAndBodyResponseValidator() {
      this.contextRunner.withPropertyValues("configuration.smsMessageEnabled=true"
          )
        .withConfiguration(AutoConfigurations.of(Config.class))
        .withUserConfiguration(SmsMessageServiceImpl.class, EmailMessageServiceImpl.class) // Agregar las clases @Service
          .run(context -> {
            Assertions.assertThat(context).hasBean("smsMessageServiceImpl");
       //     Assertions.assertThat(context).doesNotHaveBean("emailMessageServiceImpl");
          });
  }

}
