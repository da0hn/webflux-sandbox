package com.da0hn.user.application.dtos;

public record TransactionRequest(
  Double amount,
  Long idUser
) {
}
