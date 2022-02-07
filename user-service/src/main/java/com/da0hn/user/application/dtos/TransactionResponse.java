package com.da0hn.user.application.dtos;

import java.time.LocalDateTime;

public record TransactionResponse(
  Long id,
  Double amount,
  Long idUser,
  Status status,
  LocalDateTime createdAt
) {
}
