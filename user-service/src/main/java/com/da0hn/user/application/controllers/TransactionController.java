package com.da0hn.user.application.controllers;

import com.da0hn.user.application.dtos.TransactionRequest;
import com.da0hn.user.application.dtos.TransactionResponse;
import com.da0hn.user.core.usecases.user.CreateTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Component
@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

  private final CreateTransaction createTransaction;

  @PostMapping
  public Mono<TransactionResponse> create(@RequestBody final Mono<TransactionRequest> request) {
    return request.flatMap(this.createTransaction::execute);
  }

}
