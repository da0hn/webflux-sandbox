package com.da0hn.user.data;

import com.da0hn.user.core.domain.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveTransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
}
