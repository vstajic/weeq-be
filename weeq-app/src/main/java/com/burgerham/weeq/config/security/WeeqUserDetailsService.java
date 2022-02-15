package com.burgerham.weeq.config.security;

import com.burgerham.weeq.business.customer.CustomerRepository;
import com.burgerham.weeq.model.customer.Customer;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeeqUserDetailsService implements UserDetailsService {

  @Autowired
  private CustomerRepository customerRepository;

  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final Customer customer = customerRepository.findByUsername(username);
    return new User(customer.getUsername(), customer.getPassword(), new ArrayList<>());
  }
}
