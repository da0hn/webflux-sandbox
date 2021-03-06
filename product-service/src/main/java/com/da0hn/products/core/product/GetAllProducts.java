package com.da0hn.products.core.product;

import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.application.mappers.ProductResponseMapper;
import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GetAllProducts {

  private final ReactiveMongoProductRepository repository;


  public Flux<ProductResponse> execute() {
    return this.repository.findAll()
      .map(ProductResponseMapper.INSTANCE::map);
  }

}
