package org.da0hn.webflux.config;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.InputFailedValidationResponse;
import org.da0hn.webflux.exception.InputValidationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Configuration
@AllArgsConstructor
public class RouterConfig {

  private final RequestHandler handler;

  @Bean
  public RouterFunction<ServerResponse> serverResponseRouterFunction() {
    return RouterFunctions.route()
      .GET("/router/square", this.handler::squareHandler)
      .GET("/router/table", this.handler::tableHandler)
      .GET("/router/stream-table", this.handler::tableStreamHandler)
      .POST("/router/multiply", this.handler::multiplyHandler)
      .GET("/router/square-validation", this.handler::squareHandlerWithValidation)
      .onError(InputValidationException.class, this.inputValidationHandler())
      .build();
  }

  private BiFunction<Throwable, ServerRequest, Mono<ServerResponse>> inputValidationHandler() {
    return (error, request) -> {
      final InputValidationException exception = (InputValidationException) error;
      final var response = new InputFailedValidationResponse(
        exception.getErrorCode(),
        exception.getInput(),
        exception.getMessage()
      );
      return ServerResponse.badRequest().bodyValue(response);
    };
  }

}
