package com.burgerham.weeq;

import com.burgerham.weeq.business.customer.CustomerService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeeqApplication {

  @Autowired
  private CustomerService customerService;

  public static void main(String[] args) {
    SpringApplication.run(WeeqApplication.class, args);
  }

  @PostConstruct
  public void init() {
    System.out.println("Something");
    customerService.initCustomers();
  }
}
