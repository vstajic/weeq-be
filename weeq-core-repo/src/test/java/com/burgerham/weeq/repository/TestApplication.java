package com.burgerham.weeq.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.burgerham.weeq.model", "com.burgerham.weeq.repository"})
@EnableJpaRepositories("com.burgerham.weeq.repository")
@SpringBootApplication
public class TestApplication {

}
