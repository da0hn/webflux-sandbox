package org.da0hn.webflux.services;

import org.da0hn.webflux.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class AsynchronousMathService {

  private static final Duration ONE_SECOND = Duration.ofSeconds(1);
  private static final Logger LOGGER = LoggerFactory.getLogger(AsynchronousMathService.class);

  public Mono<Response> findSquare(final int input) {
    return Mono.fromSupplier(() -> input * input)
      .map(Response::new);
  }

  public Flux<Response> multiplicationTable(final int input) {
    return Flux.range(1, 10)
      .delayElements(ONE_SECOND)
      .doOnNext(index -> LOGGER.info("processing: {}", index))
      .map(index -> new Response(index * input));
  }

}
