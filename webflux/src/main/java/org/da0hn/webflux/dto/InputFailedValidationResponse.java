package org.da0hn.webflux.dto;

import lombok.Data;

@Data
public class InputFailedValidationResponse {
  private final Integer errorCode;
  private final Integer input;
  private final String message;
}
