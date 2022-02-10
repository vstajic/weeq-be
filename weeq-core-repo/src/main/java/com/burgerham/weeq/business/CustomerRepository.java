package com.burgerham.weeq.business;

import com.burgerham.weeq.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Customer findByUsername(final String username);

}
