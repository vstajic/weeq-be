package com.burgerham.weeq.model.product;

import com.burgerham.weeq.common.CurrencyCode;
import com.burgerham.weeq.model.common.BaseEntity;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

@Table(name = "price_model")
@Entity
public class PriceModel extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  private BigDecimal price;

  private BigDecimal batchPrice;

  private CurrencyCode currency;

}
