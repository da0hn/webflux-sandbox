package org.da0hn.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
  @Id
  @GeneratedValue
  private Long id;
  private String idProduct;
  private Long idUser;
  private Double amount;
  private OrderStatus status;
}
