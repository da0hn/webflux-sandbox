package com.da0hn.user.application.controllers;

import com.da0hn.user.application.dtos.TransactionRequest;
import com.da0hn.user.application.dtos.TransactionResponse;
import com.da0hn.user.core.usecases.user.CreateTransaction;
import com.da0hn.user.core.usecases.user.GetAllTransactionsOfUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

  private final CreateTransaction createTransaction;
  private final GetAllTransactionsOfUser getAllTransactionsOfUser;

  @PostMapping
  public Mono<TransactionResponse> create(@RequestBody final Mono<TransactionRequest> request) {
    return request.flatMap(this.createTransaction::execute);
  }

  @GetMapping
  public Mono<ResponseEntity<List<TransactionResponse>>> getAllTransactionsOfUser(@RequestParam("id-user") final Long iduser) {
    return this.getAllTransactionsOfUser.execute(iduser)
      .collectList()
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.noContent().build());
  }

}
