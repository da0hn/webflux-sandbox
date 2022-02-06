package com.da0hn.user.core.usecases.user;

import com.da0hn.user.application.dtos.UserResponse;
import com.da0hn.user.application.mappers.UserResponseMapper;
import com.da0hn.user.data.ReactiveUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component @AllArgsConstructor
public class GetUserById {

  private final ReactiveUserRepository repository;

  public Mono<UserResponse> execute(final Long idUser) {
    return this.repository.findById(idUser)
      .map(UserResponseMapper.INSTANCE::map);
  }

}
