package com.burgerham.weeq.model;

import com.burgerham.weeq.model.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "customer")
@Entity
public class Customer extends BaseEntity {

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;



}
