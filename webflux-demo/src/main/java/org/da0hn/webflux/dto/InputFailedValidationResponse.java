package org.da0hn.webflux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputFailedValidationResponse {
  private Integer errorCode;
  private Integer input;
  private String message;
}
