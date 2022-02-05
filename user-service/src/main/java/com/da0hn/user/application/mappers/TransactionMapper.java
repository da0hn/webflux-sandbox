package com.da0hn.user.application.mappers;

import com.da0hn.user.application.dtos.TransactionResponse;
import com.da0hn.user.core.domain.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


  @Mapping(target = "id", source = "id")
  @Mapping(target = "amount", source = "amount")
  TransactionResponse map(Transaction transaction);

}
