package com.burgerham.weeq.model.product;

import com.burgerham.weeq.model.basket.BasketItems;
import com.burgerham.weeq.model.common.BaseEntity;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

@Table(name = "product")
@Entity
public class Product extends BaseEntity {

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private List<BasketItems> basketItems;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private Set<PriceModel> priceModels;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @Column(name = "name")
  private String name;

  @Column(name = "alias")
  private String alias;

  @Column(name = "short_description")
  private String shortDescription;

  @Column(name = "full_description")
  private String fullDescription;

  @Column(name = "technical_details")
  private String technical_details;

  @Column(name = "enabled")
  private Boolean enabled = true;

  @Column(name = "available")
  private Boolean available = true;


}
