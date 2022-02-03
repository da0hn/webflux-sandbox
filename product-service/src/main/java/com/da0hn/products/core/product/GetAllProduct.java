package com.da0hn.products.core.product;

import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.application.mappers.ProductMapper;
import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GetAllProduct {

  private final ReactiveMongoProductRepository repository;


  public Flux<ProductResponse> execute() {
    return this.repository.findAll()
      .map(ProductMapper.INSTANCE::map);
  }

}
