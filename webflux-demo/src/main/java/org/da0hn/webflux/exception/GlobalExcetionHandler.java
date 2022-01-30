package org.da0hn.webflux.exception;

import org.da0hn.webflux.dto.InputFailedValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcetionHandler {


  @ExceptionHandler(InputValidationException.class)
  public ResponseEntity<InputFailedValidationResponse> handleInputValidationException(final InputValidationException exception) {
    final var response = new InputFailedValidationResponse(
      exception.getErrorCode(),
      exception.getInput(),
      exception.getMessage()
    );
    return ResponseEntity.badRequest().body(response);
  }

}
