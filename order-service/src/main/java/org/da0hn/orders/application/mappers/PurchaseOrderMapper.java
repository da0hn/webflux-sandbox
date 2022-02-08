package org.da0hn.orders.application.mappers;

import org.da0hn.orders.application.dtos.PurchaseOrderFulfillmentContext;
import org.da0hn.orders.domain.model.PurchaseOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PurchaseOrderMapper {

  PurchaseOrderMapper INSTANCE = Mappers.getMapper(PurchaseOrderMapper.class);

  @Mappings({
    @Mapping(target = "idProduct", source = "context.productResponse.id"),
    @Mapping(target = "idUser", source = "context.transactionResponse.idUser"),
    @Mapping(target = "amount", source = "context.transactionResponse.amount"),
    @Mapping(target = "status", source = "context.status")
  })
  PurchaseOrder map(PurchaseOrderFulfillmentContext context);

}
