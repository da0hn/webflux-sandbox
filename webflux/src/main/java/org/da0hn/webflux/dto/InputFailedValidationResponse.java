package org.da0hn.webflux.dto;

import lombok.Data;

@Data
public class InputFailedValidationResponse {
  private final int errorCode;
  private final int input;
  private final String message;
}
