package com.burgerham.weeq.model.basket;

import com.burgerham.weeq.model.common.BaseEntity;
import com.burgerham.weeq.model.customer.Customer;
import com.burgerham.weeq.model.product.Product;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "basket_items")
@Entity
public class BasketItem extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "quantity")
  private int quantity;

}
