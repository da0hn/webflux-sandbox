package com.da0hn.products.application.mappers;

import com.da0hn.products.application.ProductRequest;
import com.da0hn.products.core.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRequestMapper {

  ProductRequestMapper INSTANCE = Mappers.getMapper(ProductRequestMapper.class);

  @Mapping(target = "price", source = "price")
  @Mapping(target = "description", source = "description")
  Product map(ProductRequest product);
}
