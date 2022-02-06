package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.Status;
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
    @Mapping(target = "amount", source = "transaction.amount"),
    @Mapping(target = "status", source = "status")
  })
  TransactionResponse map(Transaction transaction, Status status);

}
