package com.burgerham.weeq.config.environment;

import com.burgerham.weeq.business.customer.CustomerService;
import com.burgerham.weeq.profile.WeeqProfiles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Profile(WeeqProfiles.DEV_PROFILE)
@Component
public class DevelopmentEnvironmentConfiguration extends EnvironmentConfiguration {

  final CustomerService customerService;

  @Override
  protected void createCoreData() {
    customerService.initCustomers();
  }

}
