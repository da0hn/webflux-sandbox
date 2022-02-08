package org.da0hn.orders.data.api;

import org.da0hn.orders.data.api.dtos.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FetchProductByIdImpl implements FetchProductById {

  private final WebClient webClient;

  public FetchProductByIdImpl(@Value("${app.microservice.product}") final String url) {
    this.webClient = WebClient.builder()
      .baseUrl(url)
      .build();
  }

  @Override public Mono<ProductResponse> execute(final String idProduct) {
    return this.webClient
      .get()
      .uri("/products/{id}", idProduct)
      .retrieve()
      .bodyToMono(ProductResponse.class);
  }


}
