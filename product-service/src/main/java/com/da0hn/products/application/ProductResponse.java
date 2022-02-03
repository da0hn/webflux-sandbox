package com.da0hn.products.application;

import java.util.Objects;

public class ProductResponse {
  private final String id;
  private final String description;
  private final Double price;

  public ProductResponse(
    final String id,
    final String description,
    final Double price
  ) {
    this.id = id;
    this.description = description;
    this.price = price;
  }

  public String getId() {
    return this.id;
  }

  public String getDescription() {
    return this.description;
  }

  public Double getPrice() {
    return this.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.description, this.price);
  }

  @Override
  public boolean equals(final Object obj) {
    if(obj == this) return true;
    if(obj == null || obj.getClass() != this.getClass()) return false;
    final var that = (ProductResponse) obj;
    return Objects.equals(this.id, that.id) &&
           Objects.equals(this.description, that.description) &&
           Objects.equals(this.price, that.price);
  }

  @Override
  public String toString() {
    return "ProductResponse[" +
           "id=" + this.id + ", " +
           "description=" + this.description + ", " +
           "price=" + this.price + ']';
  }
}
