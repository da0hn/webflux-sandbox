package org.da0hn.orders.application.dtos;

public record PurchaseOrderRequest(
  Long idUser,
  String idProduct
) {
}
