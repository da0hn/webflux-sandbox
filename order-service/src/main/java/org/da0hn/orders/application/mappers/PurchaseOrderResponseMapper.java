package org.da0hn.orders.application.mappers;

import org.da0hn.orders.application.dtos.PurchaseOrderResponse;
import org.da0hn.orders.domain.model.PurchaseOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PurchaseOrderResponseMapper {

  PurchaseOrderResponseMapper INSTANCE = Mappers.getMapper(PurchaseOrderResponseMapper.class);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "amount", target = "amount"),
    @Mapping(source = "idProduct", target = "idProduct"),
    @Mapping(source = "idUser", target = "idUser"),
    @Mapping(source = "status", target = "status"),
  })
  PurchaseOrderResponse map(PurchaseOrder purchaseOrder);


}
