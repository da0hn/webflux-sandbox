package org.da0hn.orders.data.api.dtos;

import java.time.LocalDateTime;

public record TransactionResponse(
  Long id,
  Double amount,
  Long idUser,
  TransactionStatus status,
  LocalDateTime createdAt
) {
}
