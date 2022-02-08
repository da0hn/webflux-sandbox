package org.da0hn.orders.data.api.dtos;

public record ProductResponse(
  String id,
  String description,
  Double price
) {
}
