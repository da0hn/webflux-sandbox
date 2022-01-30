package org.da0hn.webflux;

import org.da0hn.webflux.config.IntegrationTest;
import org.da0hn.webflux.dto.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;
import static org.junit.jupiter.api.Assertions.assertEquals;

@IntegrationTest
@DisplayName("Get Mono Responses")
class GetSingleResponseTest extends BaseTest {

  @Autowired
  private WebClient webClient;

  @Test
  @DisplayName("Blocking get one item")
  void test1() {
    final var response = this.webClient.get()
      .uri(builder -> builder.path("/asynchronous-math/square")
        .queryParam("input", 10)
        .build()
      )
      .retrieve()
      .bodyToMono(Response.class) // Mono<Response>
      .block();// Blocking operation
    final var EXPECTED = 100;
    assertEquals(EXPECTED, response.getOutput());
  }

  @Test
  @DisplayName("Non blocking get one item")
  void test2() {
    final var response = this.webClient.get()
      .uri(builder -> builder.path("/asynchronous-math/square")
        .queryParam("input", 10)
        .build()
      )
      .retrieve()
      .bodyToMono(Response.class); // Mono<Response>
    final var EXPECTED = 100;
    StepVerifier.create(response)
      .expectNextMatches(value -> value.getOutput() == EXPECTED)
      .verifyComplete();
  }
}
