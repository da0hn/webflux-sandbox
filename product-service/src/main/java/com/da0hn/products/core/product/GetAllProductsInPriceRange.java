package com.da0hn.products.core.product;

import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.application.mappers.ProductPriceRangeRequest;
import com.da0hn.products.application.mappers.ProductResponseMapper;
import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GetAllProductsInPriceRange {

  private final ReactiveMongoProductRepository repository;

  public Flux<ProductResponse> execute(final ProductPriceRangeRequest request) {
    return this.repository.findByPriceBetween(Range.closed(request.min(), request.max()))
      .map(ProductResponseMapper.INSTANCE::map);
  }


}
