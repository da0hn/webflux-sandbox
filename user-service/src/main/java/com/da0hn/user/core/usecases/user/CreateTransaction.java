package com.da0hn.user.core.usecases.user;

import com.da0hn.user.application.dtos.Status;
import com.da0hn.user.application.dtos.TransactionRequest;
import com.da0hn.user.application.dtos.TransactionResponse;
import com.da0hn.user.application.mappers.TransactionRequestMapper;
import com.da0hn.user.application.mappers.TransactionResponseMapper;
import com.da0hn.user.core.domain.Transaction;
import com.da0hn.user.data.ReactiveTransactionRepository;
import com.da0hn.user.data.ReactiveUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateTransaction {

  private final ReactiveTransactionRepository repository;
  private final ReactiveUserRepository userRepository;

  public Mono<TransactionResponse> execute(final TransactionRequest request) {
    return this.userRepository.updateUserBalance(request.idUser(), request.amount())
      .filter(Boolean::booleanValue)
      .map(value -> TransactionRequestMapper.INSTANCE.map(request))
      .flatMap(this.repository::save)
      .map(CreateTransaction::transactionApproved)
      .defaultIfEmpty(transactionDeclined(request));
  }

  private static TransactionResponse transactionDeclined(final TransactionRequest request) {
    return TransactionResponseMapper.INSTANCE.map(request, Status.DECLINED);
  }

  private static TransactionResponse transactionApproved(final Transaction newTransaction) {
    return TransactionResponseMapper.INSTANCE.map(newTransaction, Status.APPROVED);
  }

}
