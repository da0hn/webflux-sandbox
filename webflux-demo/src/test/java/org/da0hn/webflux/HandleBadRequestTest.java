package org.da0hn.webflux;

import org.da0hn.webflux.config.IntegrationTest;
import org.da0hn.webflux.dto.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException.BadRequest;
import reactor.test.StepVerifier;

@IntegrationTest
@DisplayName("Handle bad request")
class HandleBadRequestTest extends BaseTest {

  @Autowired
  private WebClient webClient;

  @Test
  @DisplayName("Handle asynchronous bad request")
  void test1() {
    final var response = this.webClient.get()
      .uri(builder -> builder.path("/asynchronous-math/async-validation")
        .queryParam("input", 1)
        .build()
      )
      .retrieve()
      .bodyToMono(Response.class)
      .doOnNext(System.out::println)
      .doOnError(err -> System.err.println(err.getMessage()));
    StepVerifier.create(response)
      .verifyError(BadRequest.class);
  }


}
