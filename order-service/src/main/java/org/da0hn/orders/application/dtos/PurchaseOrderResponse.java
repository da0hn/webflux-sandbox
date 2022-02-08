package org.da0hn.orders.application.dtos;

import org.da0hn.orders.domain.model.OrderStatus;

public record PurchaseOrderResponse(
  Long id,
  Long idUser,
  String idProduct,
  Double amount,
  OrderStatus status
) {
}
