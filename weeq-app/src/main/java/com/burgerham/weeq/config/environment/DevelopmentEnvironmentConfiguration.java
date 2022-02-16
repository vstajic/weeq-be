package com.burgerham.weeq.config.environment;

import com.burgerham.weeq.business.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Profile("dev")
@Component
public class DevelopmentEnvironmentConfiguration extends EnvironmentConfiguration {

  final CustomerService customerService;

  @Override
  protected void createCoreData() {
    customerService.initCustomers();
  }

}
