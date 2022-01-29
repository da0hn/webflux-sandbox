package org.da0hn.webflux.controllers;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.MultiplyRequest;
import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.services.AsyncMathService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/asynchronous-math")
public class AsyncMathController {

  private final AsyncMathService service;

  @GetMapping("/square")
  public Mono<Response> findSquare(@RequestParam final int input) {
    return this.service.findSquare(input);
  }

  @GetMapping("/table")
  public Flux<Response> multiplicationTable(@RequestParam final int input) {
    return this.service.multiplicationTable(input);
  }


  @GetMapping(value = "/table-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Response> multiplicationTableStream(@RequestParam final int input) {
    return this.service.multiplicationTable(input);
  }

  @PostMapping("/multiply")
  public Mono<Response> multiply(
    @RequestBody final Mono<? extends MultiplyRequest> request,
    @RequestHeader final Map<String, String> headers
  ) {
    return this.service.multiply(request);
  }

}
