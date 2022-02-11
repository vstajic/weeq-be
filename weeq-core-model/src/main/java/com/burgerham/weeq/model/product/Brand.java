package com.burgerham.weeq.model.product;

import com.burgerham.weeq.model.basket.BasketItems;
import com.burgerham.weeq.model.common.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

@Table(name = "brand")
@Entity
public class Brand extends BaseEntity {

  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private List<Product> products;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

}
