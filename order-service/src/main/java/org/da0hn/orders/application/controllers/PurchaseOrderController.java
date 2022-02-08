package org.da0hn.orders.application.controllers;

import lombok.AllArgsConstructor;
import org.da0hn.orders.application.dtos.PurchaseOrderRequest;
import org.da0hn.orders.application.dtos.PurchaseOrderResponse;
import org.da0hn.orders.domain.usecases.GetAllOrdersOfUser;
import org.da0hn.orders.domain.usecases.OrderFulfillment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class PurchaseOrderController {

  private final OrderFulfillment orderFulfillment;
  private final GetAllOrdersOfUser getAllOrdersOfUser;

  @PostMapping
  public Mono<PurchaseOrderResponse> orderFulfillment(@RequestBody final Mono<PurchaseOrderRequest> request) {
    return this.orderFulfillment.execute(request);
  }

  @GetMapping
  public Flux<PurchaseOrderResponse> getAllOrdersOfUser(@RequestParam("id-user") final Long idUser) {
    return this.getAllOrdersOfUser.execute(idUser);
  }

}
