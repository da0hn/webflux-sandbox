package org.da0hn.webflux.controllers;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.exception.InputValidationException;
import org.da0hn.webflux.services.AsynchronousMathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/asynchronous-math")
public class AsyncMathValidationController {

  private final AsynchronousMathService service;

  @GetMapping("/validation")
  public Mono<Response> findSquare(@RequestParam final int input) {
    if(input < 10 || input > 20) {
      throw new InputValidationException(input);
    }
    return this.service.findSquare(input);
  }

  @GetMapping("/async-validation")
  public Mono<Response> findSquareAsync(@RequestParam final int input) {
    return Mono.just(input)
      .handle((value, sink) -> {
        if(value < 10 || value > 20) {
          sink.error(new InputValidationException(value));
          return;
        }
        sink.next(value);
      })
      .cast(Integer.class)
      .flatMap(this.service::findSquare);
  }


  @GetMapping("/assignment")
  public Mono<ResponseEntity<Response>> assignment(@RequestParam final int input) {
    return Mono.just(input)
      .filter(value -> value >= 10 && value <= 20)
      .flatMap(this.service::findSquare)
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.badRequest().build());
  }


}
