package com.da0hn.products.application.mappers;

import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.core.product.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ProductResponseMapper {

  ProductResponseMapper INSTANCE = Mappers.getMapper(ProductResponseMapper.class);


  @Mapping(target = "id", source = "id")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "price", source = "price")
  Product map(ProductResponse product);


  @InheritInverseConfiguration
  ProductResponse map(Product product);
}
