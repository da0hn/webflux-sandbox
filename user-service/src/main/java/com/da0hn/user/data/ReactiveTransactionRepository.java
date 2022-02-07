package com.da0hn.user.data;

import com.da0hn.user.core.domain.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveTransactionRepository extends ReactiveCrudRepository<Transaction, Long> {


  Flux<Transaction> findByIdUser(Long idUser);


}
