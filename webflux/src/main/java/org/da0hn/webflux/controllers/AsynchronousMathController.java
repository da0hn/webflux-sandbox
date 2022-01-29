package org.da0hn.webflux.controllers;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.services.AsynchronousMathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/asynchronous-math")
public class AsynchronousMathController {

  private final AsynchronousMathService service;

  @GetMapping("/square")
  public Mono<Response> findSquare(@RequestParam final int input) {
    return this.service.findSquare(input);
  }

  @GetMapping("/table")
  public Flux<Response> multiplicationTable(@RequestParam final int input) {
    return this.service.multiplicationTable(input);
  }
}
