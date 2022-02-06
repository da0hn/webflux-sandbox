package com.da0hn.user.data;

import com.da0hn.user.core.domain.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveUserRepository extends ReactiveCrudRepository<User, Long> {


  @Modifying
  @Query("""
          UPDATE users SET balance = balance - :amount
          WHERE id = :idUser and balance >= :amount
         """)
  Mono<Boolean> updateUserBalance(Long idUser, Double amount);

}
