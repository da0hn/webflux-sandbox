package com.da0hn.products.core.product;

import com.da0hn.products.application.ProductRequest;
import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.application.mappers.ProductRequestMapper;
import com.da0hn.products.application.mappers.ProductResponseMapper;
import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateProduct {

  private final ReactiveMongoProductRepository repository;

  public Mono<ProductResponse> execute(final Mono<ProductRequest> request) {
    return request.map(ProductRequestMapper.INSTANCE::map)
      .flatMap(this.repository::insert)
      .map(ProductResponseMapper.INSTANCE::map);
  }

}
