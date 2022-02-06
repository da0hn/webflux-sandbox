package com.da0hn.user.core.usecases.user;

import com.da0hn.user.application.dtos.UserResponse;
import com.da0hn.user.application.mappers.UserResponseMapper;
import com.da0hn.user.data.ReactiveUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class GetAllUsers {

  private final ReactiveUserRepository repository;

  public Flux<UserResponse> execute() {
    return this.repository.findAll()
      .map(UserResponseMapper.INSTANCE::map);
  }

}
