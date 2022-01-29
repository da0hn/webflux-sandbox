package org.da0hn.webflux.dto;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class Response {

  private final LocalDate date = LocalDate.now();
  private final int output;


  public Response(final int output) {
    this.output = output;
  }


}
