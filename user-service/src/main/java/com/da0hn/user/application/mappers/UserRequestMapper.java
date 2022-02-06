package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.UserRequest;
import com.da0hn.user.core.domain.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserRequestMapper {

  UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);

  @Mapping(target = "name", source = "name")
  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "id", ignore = true)
  User map(UserRequest request);

}
