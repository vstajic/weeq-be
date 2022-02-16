package com.burgerham.weeq.web.shop.dto.product;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
public class ProductDto implements Serializable {

  private Set<PriceDto> priceModels;

  private BrandDto brand;
  private String name;
  private String alias;
  private String shortDescription;
  private String fullDescription;
  private String technicalDetails;
  private Boolean enabled = true;
  private Boolean available = true;


}
