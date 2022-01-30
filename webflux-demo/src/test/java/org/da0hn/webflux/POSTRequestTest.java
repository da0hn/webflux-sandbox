package org.da0hn.webflux;

import org.da0hn.webflux.config.IntegrationTest;
import org.da0hn.webflux.dto.MultiplyRequest;
import org.da0hn.webflux.dto.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

@IntegrationTest
@DisplayName("Non blocking POST request")
class POSTRequestTest extends BaseTest {

  @Autowired
  private WebClient webClient;

  @Test
  @DisplayName("Non blocking multiply two numbers")
  void test1() {
    final var response = this.webClient.post()
      .uri(builder -> builder.path("/asynchronous-math/multiply").build())
      .bodyValue(create(2, 3))
      .retrieve()
      .bodyToMono(Response.class) // Mono<Response>
      .doOnNext(System.out::println);
    final var EXPECTED = 6;
    StepVerifier.create(response)
      .expectNextMatches(r -> r.getOutput() == EXPECTED)
      .verifyComplete();
  }

  private static MultiplyRequest create(final int a, final int b) {
    return new MultiplyRequest(a, b);
  }

  @Test
  @DisplayName("Send data in headers")
  void test2() {

    final var response = this.webClient.post()
      .uri(builder -> builder.path("/asynchronous-math/multiply").build())
      .bodyValue(create(2, 3))
      .headers(header -> header.set("someKey", "someValue"))
      .retrieve()
      .bodyToMono(Response.class) // Mono<Response>
      .doOnNext(System.out::println);
    final var EXPECTED = 6;
    StepVerifier.create(response)
      .expectNextMatches(r -> r.getOutput() == EXPECTED)
      .verifyComplete();
  }

}
