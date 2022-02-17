package com.burgerham.weeq.web.shop.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.burgerham.weeq.web.shop.api")
@Configuration
public class WebConfig {

  public static final String API_PREFIX = "/api/shop";

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
