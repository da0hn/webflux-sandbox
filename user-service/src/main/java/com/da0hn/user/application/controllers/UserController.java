package com.da0hn.user.application.controllers;

import com.da0hn.user.application.dtos.UserRequest;
import com.da0hn.user.application.dtos.UserResponse;
import com.da0hn.user.core.usecases.user.CreateUser;
import com.da0hn.user.core.usecases.user.DeleteUserById;
import com.da0hn.user.core.usecases.user.GetAllUsers;
import com.da0hn.user.core.usecases.user.GetUserById;
import com.da0hn.user.core.usecases.user.UpdateUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final CreateUser createUser;
  private final DeleteUserById deleteUserById;
  private final GetAllUsers getAllUsers;
  private final GetUserById getUserById;
  private final UpdateUser updateUser;

  @GetMapping
  public Mono<ResponseEntity<List<UserResponse>>> getAll() {
    return this.getAllUsers.execute()
      .collectList()
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.noContent().build());
  }

  @PostMapping
  public Mono<ResponseEntity<UserResponse>> create(@RequestBody final Mono<UserRequest> request) {
    return this.createUser.execute(request)
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  @GetMapping("/{id-user}")
  public Mono<ResponseEntity<UserResponse>> getById(@PathVariable("id-user") final Long idUser) {
    return this.getUserById.execute(idUser)
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id-user}")
  public Mono<ResponseEntity<UserResponse>> update(
    @PathVariable final Mono<UserRequest> request,
    @RequestParam("id-user") final Long idUser
  ) {
    return this.updateUser.execute(request, idUser)
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id-user}")
  public Mono<ResponseEntity<Object>> deleteById(@PathVariable("id-user") final Long idUser) {
    return this.deleteUserById.execute(idUser)
      .map(e -> ResponseEntity.noContent().build())
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }


}
