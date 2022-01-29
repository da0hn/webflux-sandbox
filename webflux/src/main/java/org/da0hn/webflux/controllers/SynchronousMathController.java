package org.da0hn.webflux.controllers;

import org.da0hn.webflux.dto.Response;
import org.da0hn.webflux.services.SynchronousMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/math")
public class SynchronousMathController {

  private final SynchronousMathService service;


  @Autowired
  public SynchronousMathController(final SynchronousMathService service) {
    this.service = service;
  }

  @GetMapping("/square")
  public Response findSquare(@RequestParam final int input) {
    return this.service.findSquare(input);
  }

  @GetMapping("/table")
  public List<Response> multiplicationTable(@RequestParam final int input) {
    return this.service.multiplicationTable(input);
  }


}
