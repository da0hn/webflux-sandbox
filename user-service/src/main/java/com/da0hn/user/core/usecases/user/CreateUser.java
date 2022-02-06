package com.da0hn.user.core.usecases.user;

import com.da0hn.user.application.dtos.UserRequest;
import com.da0hn.user.application.dtos.UserResponse;
import com.da0hn.user.application.mappers.UserRequestMapper;
import com.da0hn.user.application.mappers.UserResponseMapper;
import com.da0hn.user.data.ReactiveUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateUser {

  private final ReactiveUserRepository repository;

  public Mono<UserResponse> execute(final Mono<UserRequest> request) {
    return request.map(UserRequestMapper.INSTANCE::map)
      .flatMap(this.repository::save)
      .map(UserResponseMapper.INSTANCE::map);
  }

}
