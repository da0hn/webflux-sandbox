package org.da0hn.webflux.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Response {

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss.SSSS")
  private final LocalDateTime date = LocalDateTime.now();
  private final int output;


  public Response(final int output) {
    this.output = output;
  }


}
