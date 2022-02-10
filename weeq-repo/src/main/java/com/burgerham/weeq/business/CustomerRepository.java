package com.burgerham.weeq.business;

import com.burgerham.weeq.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends JpaRepository<Customer, Long>{

  Customer findByUsername(final String username);

}
