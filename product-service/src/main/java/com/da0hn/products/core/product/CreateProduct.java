package com.da0hn.products.core.product;

import com.da0hn.products.application.ProductRequest;
import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.application.mappers.ProductMapper;
import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateProduct {

  private final ReactiveMongoProductRepository repository;

  public Mono<ProductResponse> execute(final Mono<ProductRequest> request) {
    return request.map(ProductMapper.INSTANCE::map)
      .flatMap(this.repository::insert)
      .map(ProductMapper.INSTANCE::map);
  }

}
