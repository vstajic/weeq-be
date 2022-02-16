package com.burgerham.weeq.business.product;

import com.burgerham.weeq.model.product.Product;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

  private final ProductRepository productRepository;

  public Optional<Product> findById(final long productId) {
    return productRepository.findById(productId);
  }

  public Product createProduct(final Product product) {
    return productRepository.save(product);
  }
}
