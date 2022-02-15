package com.burgerham.weeq.business.customer;

import com.burgerham.weeq.model.customer.Customer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Basic customer CRUD operations class
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final TransactionTemplate transactionTemplate;

  /**
   * Finds a single customer specified by it's given username.
   *
   * @param id customer's unique identifier
   * @return a Customer object
   */
  public Optional<Customer> findById(final long id) {
    return customerRepository.findById(id);
  }

  @Transactional(rollbackFor = Exception.class)
  public void initCustomers() {
    List<Customer> customers = Stream.of(
        new Customer("asd01@getnada.com", "ASDqwe123!", "Ewa", "Pick"),
        new Customer("asd02@getnada.com", "ASDqwe123!", "George", "Pick")
    ).collect(Collectors.toList());

    try {
      transactionTemplate.executeWithoutResult(txStatus -> customerRepository.saveAll(customers));
    } catch (Exception e) {
      log.warn(e.getMessage());
    }
  }
}
