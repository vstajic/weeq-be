package com.burgerham.weeq.business.basket;

import com.burgerham.weeq.model.basket.BasketItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
@Repository
public interface BasketRepository extends JpaRepository<BasketItem, Long>{

  List<BasketItem> findAllByCustomerId(final long customerId);


}
