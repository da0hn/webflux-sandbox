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
public class UpdateProduct {

  private final ReactiveMongoProductRepository repository;

  public Mono<ProductResponse> execute(final Mono<ProductRequest> request, final String id) {
    return this.repository.findById(id)
      .flatMap(product -> request
        .map(ProductMapper.INSTANCE::map)
        .doOnNext(requestAsProduct -> requestAsProduct.setId(id)))
      .flatMap(this.repository::save)
      .map(ProductMapper.INSTANCE::map);
  }


}
