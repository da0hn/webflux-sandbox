package org.da0hn.webflux.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MultiplyRequest {

  private final int first;
  private final int second;

}
