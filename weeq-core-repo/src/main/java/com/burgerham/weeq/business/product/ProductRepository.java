package com.burgerham.weeq.business.product;

import com.burgerham.weeq.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
