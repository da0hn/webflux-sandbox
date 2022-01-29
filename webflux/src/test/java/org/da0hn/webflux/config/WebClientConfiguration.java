package org.da0hn.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

  @Bean
  public WebClient webClient() {
    return WebClient.builder()
      .baseUrl("http://localhost:8080/webflux-sandbox")
      .build();
  }


}
