package com.da0hn.products.core.product;

import com.da0hn.products.data.ReactiveMongoProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class DeleteProductById {

  private final ReactiveMongoProductRepository repository;


  public Mono<Void> execute(final String id) {
    return this.repository.deleteById(id);
  }


}
