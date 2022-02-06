package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.TransactionRequest;
import com.da0hn.user.core.domain.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionRequestMapper {

  TransactionRequestMapper INSTANCE = Mappers.getMapper(TransactionRequestMapper.class);


  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idUser", ignore = true)
  @Mapping(target = "date", expression = "java(java.time.LocalDateTime.now())")
  Transaction map(TransactionRequest request);

}
