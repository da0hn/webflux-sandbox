package com.da0hn.products;

import com.da0hn.products.application.ProductRequest;
import com.da0hn.products.application.mappers.ProductRequestMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit")
@DisplayName("Testes de conversões de um `ProductRequest` para `Product`")
class ProductRequestMapperTest {


  @Test
  @DisplayName("Deveria mapear um `ProductRequest` para `Product`")
  void test1() {
    final var request = new ProductRequest("description 1", 20.5);
    final var instance = ProductRequestMapper.INSTANCE;
    final var output = instance.map(request);
    assertThat(output.getDescription()).isEqualTo(request.getDescription());
    assertThat(output.getPrice()).isEqualTo(request.getPrice());
  }


}
