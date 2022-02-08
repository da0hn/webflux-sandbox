package org.da0hn.orders.domain.usecases;

import lombok.AllArgsConstructor;
import org.da0hn.orders.application.dtos.PurchaseOrderResponse;
import org.da0hn.orders.application.mappers.PurchaseOrderResponseMapper;
import org.da0hn.orders.data.db.JpaPurchaseOrderRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component
@AllArgsConstructor
public class GetAllOrdersOfUser {

  private final JpaPurchaseOrderRepository repository;

  public Flux<PurchaseOrderResponse> execute(final Long idUser) {
    return Flux.fromStream(() -> this.repository.findByIdUser(idUser).stream())
      .map(PurchaseOrderResponseMapper.INSTANCE::map)
      .subscribeOn(Schedulers.boundedElastic());
  }


}
