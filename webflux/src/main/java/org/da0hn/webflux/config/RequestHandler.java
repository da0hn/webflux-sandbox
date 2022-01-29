package org.da0hn.webflux.config;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.MultiplyRequest;
import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.exception.InputValidationException;
import org.da0hn.webflux.services.AsyncMathService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RequestHandler {

  private final AsyncMathService service;

  public Mono<ServerResponse> squareHandler(final ServerRequest serverRequest) {
    final var input = serverRequest.queryParam("input")
      .map(Integer::parseInt)
      .orElse(null);
    final var square = this.service.findSquare(input);
    return ServerResponse.ok().body(square, Response.class);
  }

  public Mono<ServerResponse> squarePathVariableHandler(final ServerRequest serverRequest) {
    final var input = Integer.parseInt(serverRequest.pathVariable("input"));
    final var square = this.service.findSquare(input);
    return ServerResponse.ok().body(square, Response.class);
  }

  public Mono<ServerResponse> tableHandler(final ServerRequest serverRequest) {
    final var input = serverRequest.queryParam("input")
      .map(Integer::parseInt)
      .orElse(null);
    final var square = this.service.multiplicationTable(input);
    return ServerResponse.ok().body(square, Response.class);
  }

  public Mono<ServerResponse> tableStreamHandler(final ServerRequest serverRequest) {
    final var input = serverRequest.queryParam("input")
      .map(Integer::parseInt)
      .orElse(null);
    final var square = this.service.multiplicationTable(input);
    return ServerResponse.ok()
      .contentType(MediaType.TEXT_EVENT_STREAM)
      .body(square, Response.class);
  }

  public Mono<ServerResponse> multiplyHandler(final ServerRequest serverRequest) {
    final var request = serverRequest.bodyToMono(MultiplyRequest.class);
    final var response = this.service.multiply(request);
    return ServerResponse.ok().body(response, Response.class);
  }

  public Mono<ServerResponse> squareHandlerWithValidation(final ServerRequest serverRequest) {
    final var input = serverRequest.queryParam("input")
      .map(Integer::parseInt)
      .orElse(null);

    if(input == null) {
      return Mono.error(new InputValidationException(null));
    }

    if(input < 10 || input > 20) {
      return Mono.error(new InputValidationException(input));
    }

    final var square = this.service.findSquare(input);
    return ServerResponse.ok().body(square, Response.class);
  }
}
