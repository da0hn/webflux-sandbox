package org.da0hn.webflux.exception;

import java.io.Serial;

public class InputValidationException extends RuntimeException {

  @Serial private static final long serialVersionUID = 357142322099074987L;

  private static final String message = "Allowed range is 10 - 20";
  private final int errorCode = 100;
  private final Integer input;

  public InputValidationException(final Integer input) {
    super(message);
    this.input = input;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public Integer getInput() {
    return this.input;
  }
}
