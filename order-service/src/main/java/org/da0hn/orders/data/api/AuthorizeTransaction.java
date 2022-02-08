package org.da0hn.orders.data.api;

import org.da0hn.orders.data.api.dtos.TransactionRequest;
import org.da0hn.orders.data.api.dtos.TransactionResponse;
import reactor.core.publisher.Mono;

public interface AuthorizeTransaction {
  Mono<TransactionResponse> execute(final TransactionRequest request);
}
