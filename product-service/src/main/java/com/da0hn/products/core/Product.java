package com.da0hn.products.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
  private String id;
  private String description;
  private Double price;

  @Override public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override public boolean equals(final Object o) {
    if(this == o) return true;
    if(!(o instanceof final Product product)) return false;
    return this.id.equals(product.id);
  }
}
