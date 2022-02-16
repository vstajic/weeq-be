package com.burgerham.weeq.business.product;

import com.burgerham.weeq.model.product.Brand;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandService {

  private final BrandRepository brandRepository;

  public Optional<Brand> findById(final long id) {
    return brandRepository.findById(id);
  }

  public Brand createBrand(final Brand brand) {
    return brandRepository.save(brand);
  }
}
