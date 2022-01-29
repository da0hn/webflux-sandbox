package org.da0hn.webflux.services;

import org.da0hn.webflux.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class SyncMathService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SyncMathService.class);


  public Response findSquare(final int input) {
    return new Response(input * input);
  }

  public List<Response> multiplicationTable(final int input) {
    return IntStream.rangeClosed(1, 10)
      .peek(index -> SleepUtil.sleep(1))
      .peek(index -> LOGGER.info("processing: {}", index))
      .mapToObj(index -> new Response(index * input))
      .toList();
  }

}
