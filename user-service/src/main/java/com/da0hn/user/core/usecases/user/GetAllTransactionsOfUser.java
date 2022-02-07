package com.da0hn.user.core.usecases.user;

import com.da0hn.user.application.dtos.TransactionResponse;
import com.da0hn.user.application.mappers.TransactionResponseMapper;
import com.da0hn.user.data.ReactiveTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GetAllTransactionsOfUser {

  private final ReactiveTransactionRepository repository;

  public Flux<TransactionResponse> execute(final Long idUser) {
    return this.repository.findByIdUser(idUser)
      .map(TransactionResponseMapper.INSTANCE::map);
  }

}
