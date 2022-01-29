package org.da0hn.webflux.config;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Service
public class CalculatorHandler {

  public Mono<ServerResponse> additionHandler(final ServerRequest request) {
    return process(request, Integer::sum);
  }

  private static Mono<ServerResponse> process(
    final ServerRequest request,
    final BiFunction<? super Integer, ? super Integer, ? extends Integer> operation
  ) {
    final var a = getValue(request, "a");
    final var b = getValue(request, "b");
    return ServerResponse.ok().bodyValue(operation.apply(a, b));
  }

  private static Integer getValue(final ServerRequest request, final String key) {
    return Integer.parseInt(request.pathVariable(key));
  }

  public Mono<ServerResponse> subtractionHandler(final ServerRequest request) {
    return process(request, Math::subtractExact);
  }

  public Mono<ServerResponse> multiplicationHandler(final ServerRequest request) {
    return process(request, Math::multiplyExact);
  }

  public Mono<ServerResponse> divisionHandler(final ServerRequest request) {
    return process(request, (dividend, divisor) -> {
      if(divisor == 0) return 0;
      return Integer.divideUnsigned(dividend, divisor);
    });
  }

}
