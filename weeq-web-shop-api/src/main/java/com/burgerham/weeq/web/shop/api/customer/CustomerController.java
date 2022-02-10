package com.burgerham.weeq.web.shop.api.customer;

import com.burgerham.weeq.business.customer.CustomerService;
import com.burgerham.weeq.model.Customer;
import com.burgerham.weeq.web.shop.dto.customer.CustomerDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {

  private final CustomerService customerService;
  private final ModelMapper modelMapper;

  @GetMapping(path = "/{id}")
  public ResponseEntity<CustomerDto> findCustomerById(@PathVariable @NonNull final long id) {
    final Optional<Customer> customer = customerService.findById(id);
    if (customer.isPresent()) {
      final CustomerDto customerModel = modelMapper.map(customer.get(), CustomerDto.class);
      return ResponseEntity.ok(customerModel);
    } else {
      return ResponseEntity.noContent().build();
    }
  }
}
