package com.burgerham.weeq.web.shop.dto.product;

import com.burgerham.weeq.lib.currency.CurrencyCode;
import java.io.Serializable;
import lombok.Data;

@Data
public class PriceDto implements Serializable {

  private double price;
  private double batchPrice;
  private CurrencyCode currency;

}
