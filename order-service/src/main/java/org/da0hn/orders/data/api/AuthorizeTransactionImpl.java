package org.da0hn.orders.data.api;

import org.da0hn.orders.data.api.dtos.TransactionRequest;
import org.da0hn.orders.data.api.dtos.TransactionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthorizeTransactionImpl implements AuthorizeTransaction {

  private final WebClient webClient;


  public AuthorizeTransactionImpl(@Value("${app.microservice.user}") final String url) {
    this.webClient = WebClient.builder()
      .baseUrl(url)
      .build();
  }

  @Override
  public Mono<TransactionResponse> execute(final TransactionRequest request) {
    return this.webClient
      .post()
      .uri("transactions")
      .bodyValue(request)
      .retrieve()
      .bodyToMono(TransactionResponse.class);

  }


}
