package org.da0hn.webflux.services;

import org.da0hn.webflux.dto.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class MathService {


  public Response findSquare(final int input) {
    return new Response(input * input);
  }

  public List<Response> multiplicationTable(final int input) {
    return IntStream.rangeClosed(1, 10)
      .peek(index -> SleepUtil.sleep(1))
      .peek(index -> System.out.println("math-service processing: " + index))
      .mapToObj(index -> new Response(index * input))
      .toList();
  }

}
