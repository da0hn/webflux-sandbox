package com.da0hn.products.application;

public record ProductRequest(
  String id,
  String description,
  Double price
) {
}
