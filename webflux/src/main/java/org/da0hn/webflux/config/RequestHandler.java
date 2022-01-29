package org.da0hn.webflux.config;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.services.AsyncMathService;
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

  public Mono<ServerResponse> tableHandler(final ServerRequest serverRequest) {
    final var input = serverRequest.queryParam("input")
      .map(Integer::parseInt)
      .orElse(null);
    final var square = this.service.multiplicationTable(input);
    return ServerResponse.ok().body(square, Response.class);
  }
}
