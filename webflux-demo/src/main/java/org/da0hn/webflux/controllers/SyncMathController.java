package org.da0hn.webflux.controllers;

import lombok.AllArgsConstructor;
import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.services.SyncMathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/synchronous-math")
public class SyncMathController {

  private final SyncMathService service;

  @GetMapping("/square")
  public Response findSquare(@RequestParam final int input) {
    return this.service.findSquare(input);
  }

  @GetMapping("/table")
  public List<Response> multiplicationTable(@RequestParam final int input) {
    return this.service.multiplicationTable(input);
  }


}
