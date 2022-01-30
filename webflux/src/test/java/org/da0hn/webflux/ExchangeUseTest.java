package org.da0hn.webflux;

import org.da0hn.webflux.config.IntegrationTest;
import org.da0hn.webflux.dto.InputFailedValidationResponse;
import org.da0hn.webflux.dto.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@IntegrationTest
@DisplayName("Applying exchangeToMono method")
class ExchangeUseTest extends BaseTest {

  @Autowired
  private WebClient webClient;

  @Test
  @DisplayName("Handle bad request using `exchangeToMono`")
  void test1() {
    final var response = this.webClient.get()
      .uri(builder -> builder.path("/asynchronous-math/async-validation")
        .queryParam("input", 1)
        .build()
      )
      .exchangeToMono(ExchangeUseTest::exchange)
      .doOnNext(System.out::println)
      .doOnError(err -> System.err.println(err.getMessage()));
    StepVerifier.create(response)
      .expectNextCount(1)
      .verifyComplete();
  }

  private static Mono<Object> exchange(final ClientResponse clientResponse) {
    if(clientResponse.statusCode().value() == 400) {
      return clientResponse.bodyToMono(InputFailedValidationResponse.class);
    }
    else {
      return clientResponse.bodyToMono(Response.class);
    }
  }


}
