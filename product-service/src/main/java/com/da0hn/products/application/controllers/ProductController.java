package com.da0hn.products.application.controllers;

import com.da0hn.products.application.ProductRequest;
import com.da0hn.products.application.ProductResponse;
import com.da0hn.products.core.product.CreateProduct;
import com.da0hn.products.core.product.DeleteProductById;
import com.da0hn.products.core.product.GetAllProducts;
import com.da0hn.products.core.product.GetProductById;
import com.da0hn.products.core.product.UpdateProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final CreateProduct createProduct;
  private final DeleteProductById deleteProductById;
  private final GetAllProducts getAllProducts;
  private final GetProductById getProductById;
  private final UpdateProduct updateProduct;

  @PostMapping
  public Mono<ProductResponse> create(@RequestBody final Mono<ProductRequest> request) {
    return this.createProduct.execute(request);
  }

  @GetMapping("/{id-product}")
  public Mono<ResponseEntity<ProductResponse>> getById(@PathVariable("id-product") final String id) {
    return this.getProductById.execute(id)
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping
  public Flux<ProductResponse> getAll() {
    return this.getAllProducts.execute();
  }

  @PutMapping("/{id-product}")
  public Mono<ResponseEntity<ProductResponse>> update(
    @RequestBody final Mono<? extends ProductRequest> request,
    @PathVariable("id-product") final String id
  ) {
    return this.updateProduct.execute(request, id)
      .map(ResponseEntity::ok)
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id-product}")
  public Mono<Void> delete(@PathVariable("id-product") final String id) {
    return this.deleteProductById.execute(id);
  }


}
