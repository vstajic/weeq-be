package com.burgerham.weeq.business.basket;

import com.burgerham.weeq.model.basket.BasketItem;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class BasketService {

  private final BasketRepository basketRepository;

  public List<BasketItem> listBasketItems(final long customerId) {
    return basketRepository.findAllByCustomerId(customerId);
  }

}
