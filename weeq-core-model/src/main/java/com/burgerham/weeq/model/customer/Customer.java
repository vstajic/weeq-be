package com.burgerham.weeq.model.customer;

import com.burgerham.weeq.model.basket.BasketItems;
import com.burgerham.weeq.model.common.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "customer")
@Entity
public class Customer extends BaseEntity {

  @OneToOne(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private CustomerAddress address;

  @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private List<BasketItems> basketItems;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  public Customer(final String username, final String password, final String firstName, final String lastName) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
