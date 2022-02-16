package com.burgerham.weeq.model.product;

import com.burgerham.weeq.model.currency.CurrencyCode;
import com.burgerham.weeq.model.common.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Table(name = "price_model")
@Entity
public class PriceModel extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product productId;

  private BigDecimal price;

  private BigDecimal batchPrice;

  private CurrencyCode currency;

}
