package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.UserResponse;
import com.da0hn.user.core.domain.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserResponseMapper {

  UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "amount", source = "amount")
  UserResponse map(User user);
}
