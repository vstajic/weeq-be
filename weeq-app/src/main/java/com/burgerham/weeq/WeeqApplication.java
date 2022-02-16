package com.burgerham.weeq;

import com.burgerham.weeq.security.config.SecurityConfig;
import com.burgerham.weeq.web.shop.api.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({SecurityConfig.class, WebConfig.class})
@SpringBootApplication
public class WeeqApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeeqApplication.class, args);
  }

}
