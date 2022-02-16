package com.burgerham.weeq.web.shop.dto.basket;

import com.burgerham.weeq.web.shop.dto.product.ProductDto;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class BasketItemsDto implements Serializable {

  private List<ProductDto> productId;
  private long customerId;

}
