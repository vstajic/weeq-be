package com.burgerham.weeq.business.customer;

import com.burgerham.weeq.business.CustomerRepository;
import com.burgerham.weeq.model.customer.Customer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

  public void initCustomers() {
    List<Customer> customers = Stream.of(
        new Customer("asd01@getnada.com", "ASDqwe123!", "Ewa", "Pick"),
        new Customer("asd02@getnada.com", "ASDqwe123!", "George", "Pick")
    ).collect(Collectors.toList());

    customerRepository.saveAll(customers);
  }
}
