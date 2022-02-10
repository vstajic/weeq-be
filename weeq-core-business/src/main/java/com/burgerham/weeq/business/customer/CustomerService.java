package com.burgerham.weeq.business.customer;

import com.burgerham.weeq.business.CustomerRepository;
import com.burgerham.weeq.model.Customer;
import java.util.Optional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Basic customer CRUD operations class
 */
@Data
@RequiredArgsConstructor
@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  /**
   * Finds a single customer specified by it's given username.
   *
   * @param id customer's unique identifier
   * @return a Customer object
   */
  public Optional<Customer> findById(final long id) {
    return customerRepository.findById(id);
  }

}
