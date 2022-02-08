package org.da0hn.orders.data.api.dtos;

public record TransactionRequest(
  Double amount,
  Long idUser
) {
}
