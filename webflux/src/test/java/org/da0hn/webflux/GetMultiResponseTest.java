package org.da0hn.webflux;

import org.da0hn.webflux.dto.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

class GetMultiResponseTest extends BaseTest {

  @Autowired
  private WebClient webClient;


  @Test
  @DisplayName("Non blocking get list")
  void test1() {
    final var response = this.webClient.get()
      .uri(builder -> builder.path("/asynchronous-math/table")
        .queryParam("input", 10)
        .build()
      )
      .retrieve()
      .bodyToFlux(Response.class) // Flux<Response>
      .doOnNext(System.out::println);

    StepVerifier.create(response)
      .expectNextCount(10)
      .verifyComplete();
  }

  @Test
  @DisplayName("Non blocking get list as Stream")
  void test2() {
    final var response = this.webClient.get()
      .uri(builder -> builder.path("/asynchronous-math/table-stream")
        .queryParam("input", 10)
        .build()
      )
      .retrieve()
      .bodyToFlux(Response.class) // Flux<Response>
      .doOnNext(System.out::println);

    StepVerifier.create(response)
      .expectNextCount(10)
      .verifyComplete();
  }
}
