package org.da0hn.orders.data.api;

import org.da0hn.orders.data.api.dtos.ProductResponse;
import reactor.core.publisher.Mono;

public interface FetchProductById {
  Mono<ProductResponse> execute(String idProduct);
}
