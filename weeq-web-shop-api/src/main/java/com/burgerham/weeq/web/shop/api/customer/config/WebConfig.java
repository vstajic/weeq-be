package com.burgerham.weeq.web.shop.api.customer.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.burgerham.weeq.web.shop.api")
@Configuration
public class WebConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
