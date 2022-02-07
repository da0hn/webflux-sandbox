package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.Status;
import com.da0hn.user.application.dtos.TransactionRequest;
import com.da0hn.user.application.dtos.TransactionResponse;
import com.da0hn.user.core.domain.Transaction;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface TransactionResponseMapper {

  TransactionResponseMapper INSTANCE = Mappers.getMapper(TransactionResponseMapper.class);


  @Mappings({
    @Mapping(target = "id", source = "transaction.id"),
    @Mapping(target = "createdAt", source = "transaction.date"),
    @Mapping(target = "idUser", source = "transaction.idUser"),
    @Mapping(target = "amount", source = "transaction.amount"),
    @Mapping(target = "status", source = "status")
  })
  TransactionResponse map(Transaction transaction, Status status);

  @Mappings({
    @Mapping(target = "id", source = "transaction.id"),
    @Mapping(target = "createdAt", source = "transaction.date"),
    @Mapping(target = "idUser", source = "transaction.idUser"),
    @Mapping(target = "amount", source = "transaction.amount"),
    @Mapping(target = "status", ignore = true)
  })
  TransactionResponse map(Transaction transaction);

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())"),
    @Mapping(target = "idUser", source = "request.idUser"),
    @Mapping(target = "amount", source = "request.amount"),
    @Mapping(target = "status", source = "status")
  })
  TransactionResponse map(TransactionRequest request, Status status);

}
