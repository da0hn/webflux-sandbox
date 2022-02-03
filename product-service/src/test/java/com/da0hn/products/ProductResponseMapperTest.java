package com.da0hn.products;

import com.da0hn.products.application.mappers.ProductResponseMapper;
import com.da0hn.products.core.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit")
@DisplayName("Testes de conversões de um `Product` para `ProductResponse`")
class ProductResponseMapperTest {

  @Test
  @DisplayName("Deveria mapear um `Product` para `ProductResponse`")
  void test1() {
    final var product = new Product();
    product.setId(UUID.randomUUID().toString());
    product.setDescription("Description 1");
    product.setPrice(20.0);

    final var output = ProductResponseMapper.INSTANCE.map(product);

    assertThat(output.getId()).isEqualTo(product.getId());
    assertThat(output.getDescription()).isEqualTo(product.getDescription());
    assertThat(output.getPrice()).isEqualTo(product.getPrice());
  }


}
