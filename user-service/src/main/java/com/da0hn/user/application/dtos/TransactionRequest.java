package com.da0hn.user.application.dtos;

public record TransactionRequest(
  Long id,
  Double amount,
  Long idUser
) {
}
