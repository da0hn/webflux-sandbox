package org.da0hn.orders.data.db;

import org.da0hn.orders.domain.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
