package org.da0hn.orders.domain.usecases;

import lombok.AllArgsConstructor;
import org.da0hn.orders.application.dtos.PurchaseOrderFulfillmentContext;
import org.da0hn.orders.application.dtos.PurchaseOrderRequest;
import org.da0hn.orders.application.dtos.PurchaseOrderResponse;
import org.da0hn.orders.application.mappers.PurchaseOrderMapper;
import org.da0hn.orders.application.mappers.PurchaseOrderResponseMapper;
import org.da0hn.orders.data.api.AuthorizeTransaction;
import org.da0hn.orders.data.api.FetchProductById;
import org.da0hn.orders.data.db.JpaPurchaseOrderRepository;
import org.da0hn.orders.domain.model.PurchaseOrder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
@AllArgsConstructor
public class OrderFulfillment {


  private final FetchProductById fetchProductById;
  private final AuthorizeTransaction authorizeTransaction;

  private final JpaPurchaseOrderRepository repository;

  public Mono<PurchaseOrderResponse> execute(final Mono<PurchaseOrderRequest> request) {
    return request.map(PurchaseOrderFulfillmentContext::new)
      .flatMap(this::fetchProduct)
      .doOnNext(PurchaseOrderFulfillmentContext::setupTransactionRequest)
      .map(this::authorizeTransaction)
      .flatMap(this::createPurchaseOrderRecord)
      .map(PurchaseOrderResponseMapper.INSTANCE::map);
  }

  private Mono<PurchaseOrderFulfillmentContext> authorizeTransaction(final PurchaseOrderFulfillmentContext context) {
    return this.authorizeTransaction.execute(context.getTransactionRequest())
      .doOnNext(context::setTransactionResponse)
      .thenReturn(context);
  }

  private Mono<PurchaseOrderFulfillmentContext> fetchProduct(final PurchaseOrderFulfillmentContext context) {
    return this.fetchProductById.execute(context.idProduct())
      .doOnNext(context::setProductResponse)
      .thenReturn(context);
  }

  private Mono<PurchaseOrder> createPurchaseOrderRecord(final Mono<? extends PurchaseOrderFulfillmentContext> context) {
    return context.map(ctx -> {
        final var purchaseOrder = PurchaseOrderMapper.INSTANCE.map(ctx);
        return this.repository.save(purchaseOrder); // blocking operation
      })
      .subscribeOn(Schedulers.boundedElastic());  // avoid blocking operation
  }

}
