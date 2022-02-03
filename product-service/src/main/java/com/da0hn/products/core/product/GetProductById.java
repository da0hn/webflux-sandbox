package com.da0hn.products.core.product;

import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.application.mappers.ProductResponseMapper;
import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class GetProductById {

  private final ReactiveMongoProductRepository repository;


  public Mono<ProductResponse> execute(final String id) {
    return this.repository.findById(id)
      .map(ProductResponseMapper.INSTANCE::map);
  }

}
