package com.da0hn.products.application.mappers;

import com.da0hn.products.application.ProductRequest;
import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.core.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  @Mapping(target = "description", source = "description")
  @Mapping(target = "price", source = "price")
  Product map(ProductRequest product);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "price", source = "price")
  ProductResponse map(Product product);
}
