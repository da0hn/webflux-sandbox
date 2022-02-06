package com.da0hn.user.core.usecases.user;

import com.da0hn.user.data.ReactiveUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class DeleteUserById {

  private final ReactiveUserRepository repository;

  public Mono<Void> execute(final Long idUser) {
    return this.repository.deleteById(idUser);
  }

}
