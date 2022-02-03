package com.da0hn.products.application;

import java.util.Objects;

public class ProductRequest {
  private final String description;
  private final Double price;

  public ProductRequest(
    final String description,
    final Double price
  ) {
    this.description = description;
    this.price = price;
  }

  public String getDescription() {
    return this.description;
  }

  public Double getPrice() {
    return this.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.description, this.price);
  }

  @Override
  public boolean equals(final Object obj) {
    if(obj == this) return true;
    if(obj == null || obj.getClass() != this.getClass()) return false;
    final var that = (ProductRequest) obj;
    return Objects.equals(this.description, that.description) &&
           Objects.equals(this.price, that.price);
  }

  @Override
  public String toString() {
    return "ProductRequest[" +
           "description=" + this.description + ", " +
           "price=" + this.price + ']';
  }

}
