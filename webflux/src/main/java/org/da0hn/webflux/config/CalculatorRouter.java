package org.da0hn.webflux.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class CalculatorRouter {

  private final CalculatorHandler handler;

  @Bean
  public RouterFunction<ServerResponse> calculatorRouters() {
    return RouterFunctions.route()
      .path("/calculators", this::calculatorHandlers)
      .build();
  }

  private RouterFunction<ServerResponse> calculatorHandlers() {
    return RouterFunctions.route()
      .GET("/{a}/{b}", operation("+"), this.handler::additionHandler)
      .GET("/{a}/{b}", operation("-"), this.handler::subtractionHandler)
      .GET("/{a}/{b}", operation("*"), this.handler::multiplicationHandler)
      .GET("/{a}/{b}", operation("/"), this.handler::divisionHandler)
      .GET("/{a}/{b}", req -> ServerResponse.badRequest().bodyValue("Operation invalid, should be [+, -, *, /]"))
      .build();
  }

  private static RequestPredicate operation(final String operation) {
    return RequestPredicates.headers(headers -> operation.equals(
      headers.asHttpHeaders()
        .toSingleValueMap()
        .get("operation"))
    );
  }


}
