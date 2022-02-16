package com.burgerham.weeq.web.shop.api.product;

import com.burgerham.weeq.business.product.BrandService;
import com.burgerham.weeq.model.product.Brand;
import com.burgerham.weeq.web.shop.dto.product.BrandDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/shop/brands")
public class BrandController {

  private final BrandService brandService;
  private final ModelMapper modelMapper;

  @GetMapping(path = "/{id}")
  public ResponseEntity<BrandDto> findById(@PathVariable @NonNull final long id) {
    final Optional<Brand> brand = brandService.findById(id);
    if (brand.isPresent()) {
      final BrandDto brandModel = modelMapper.map(brand.get(), BrandDto.class);
      return ResponseEntity.ok(brandModel);
    } else {
      return ResponseEntity.noContent().build();
    }
  }

  @PostMapping
  public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandModel) {
    Brand brand = modelMapper.map(brandModel, Brand.class);
    Optional<Brand> newBrand = Optional.ofNullable(brandService.createBrand(brand));

    if (newBrand.isPresent()) {
      BrandDto outputBrand = modelMapper.map(newBrand.get(), BrandDto.class);
      return ResponseEntity.ok(outputBrand);
    } else {
      return ResponseEntity.noContent().build();
    }
  }

}
