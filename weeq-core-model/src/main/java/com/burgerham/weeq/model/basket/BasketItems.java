package com.burgerham.weeq.model.basket;

import com.burgerham.weeq.model.common.BaseEntity;
import com.burgerham.weeq.model.customer.Customer;
import com.burgerham.weeq.model.product.Product;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

@Table(name = "basket_items")
@Entity
public class BasketItems extends BaseEntity {

  @ManyToOne
  @Column(name = "customer_id")
  private Customer customerId;

  @ManyToOne
  @Column(name = "product_id")
  private Product productId;

  @Column(name = "quantity")
  private int quantity;

}
