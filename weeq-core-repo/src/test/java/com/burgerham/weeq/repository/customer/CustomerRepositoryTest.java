package com.burgerham.weeq.repository.customer;

import com.burgerham.weeq.business.customer.CustomerRepository;
import com.burgerham.weeq.model.customer.Customer;
import com.burgerham.weeq.repository.AbstractTransactionalRepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(initializers = {CustomerRepositoryTest.Initializer.class})
@ActiveProfiles("integrationTest")
public class CustomerRepositoryTest extends AbstractTransactionalRepositoryTest {

  public static class Initializer extends AbstractTransactionalRepositoryTest.Initializer {

  }

  private Customer customer;

  @Autowired
  private CustomerRepository customerRepository;

  @BeforeEach
  void setUp() {
    customer = Customer.builder()
        .username("asd01@getnada.com")
        .password("ASDqwe123!")
        .firstName("Peppa")
        .lastName("Pig")
        .build();
    customerRepository.saveAndFlush(customer);
  }

  @Test
  void testCustomerCreation() {
    thenVersionedEntityFieldsAreSet(customer);
  }
}
