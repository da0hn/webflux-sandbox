package org.da0hn.orders.application.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.da0hn.orders.data.api.dtos.ProductResponse;
import org.da0hn.orders.data.api.dtos.TransactionRequest;
import org.da0hn.orders.data.api.dtos.TransactionResponse;
import org.da0hn.orders.domain.model.OrderStatus;

import static org.da0hn.orders.domain.model.OrderStatus.COMPLETED;
import static org.da0hn.orders.domain.model.OrderStatus.FAILED;

@Getter
@Setter
@RequiredArgsConstructor
public class PurchaseOrderFulfillmentContext {

  private final PurchaseOrderRequest purchaseOrderRequest;
  private ProductResponse productResponse;
  private TransactionRequest transactionRequest;
  private TransactionResponse transactionResponse;


  public String idProduct() {
    return this.purchaseOrderRequest.idProduct();
  }

  public void setupTransactionRequest() {
    this.transactionRequest = new TransactionRequest(
      this.productResponse.price(),
      this.purchaseOrderRequest.idUser()
    );
  }

  public OrderStatus getStatus() {
    return switch(this.transactionResponse.status()) {
      case APPROVED -> COMPLETED;
      default -> FAILED;
    };
  }

}
