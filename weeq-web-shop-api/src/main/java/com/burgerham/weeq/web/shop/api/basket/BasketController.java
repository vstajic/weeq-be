package com.burgerham.weeq.web.shop.api.basket;

import com.burgerham.weeq.business.basket.BasketService;
import com.burgerham.weeq.model.basket.BasketItem;
import com.burgerham.weeq.web.shop.dto.basket.BasketItemsDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/shop/basket")
@RequiredArgsConstructor
@RestController
public class BasketController {

  private final BasketService basketService;
  private final ModelMapper modelMapper;

  //  @PreAuthorize("hasAuthority('\" + MintPermissions.CUSTOMER_AUTHORITY_VALUE + \"')")
  @GetMapping()
  public ResponseEntity<List<BasketItemsDto>> listBasketItems() {
    List<BasketItem> items = basketService.listBasketItems(1L);
    if (CollectionUtils.isEmpty(items)) {
      return ResponseEntity.noContent().build();
    }
    List<BasketItemsDto> basketItemsDtos = modelMapper.map(items, new TypeToken<List<BasketItem>>() {
    }.getType());
    return ResponseEntity.ok(basketItemsDtos);
  }
}
