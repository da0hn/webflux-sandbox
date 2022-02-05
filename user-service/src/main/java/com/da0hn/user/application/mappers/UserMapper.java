package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.UserRequest;
import com.da0hn.user.application.dtos.UserResponse;
import com.da0hn.user.core.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "name", source = "name")
  @Mapping(target = "balance", source = "balance")
  User map(UserRequest request);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "balance", source = "balance")
  UserResponse map(User user);

}
