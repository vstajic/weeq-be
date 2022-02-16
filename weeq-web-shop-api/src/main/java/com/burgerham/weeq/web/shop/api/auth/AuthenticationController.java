package com.burgerham.weeq.web.shop.api.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  @GetMapping(path = "/hello")
  public String helloWorld() {
    return "HELLO WORLD";
  }

}
