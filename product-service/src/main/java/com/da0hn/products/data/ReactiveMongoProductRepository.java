package com.da0hn.products.data;

import com.da0hn.products.core.product.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveMongoProductRepository extends ReactiveMongoRepository<Product, String> {

  Flux<Product> findByPriceBetween(Range<Double> range);

}
