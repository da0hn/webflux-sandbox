package com.da0hn.products.data;

import com.da0hn.products.core.product.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveMongoProductRepository extends ReactiveMongoRepository<Product, String> {
}
