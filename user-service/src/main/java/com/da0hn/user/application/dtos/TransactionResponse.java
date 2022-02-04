package com.da0hn.user.application.dtos;

public record TransactionResponse(
  Long id,
  Long amount,
  Status status
) {
}
