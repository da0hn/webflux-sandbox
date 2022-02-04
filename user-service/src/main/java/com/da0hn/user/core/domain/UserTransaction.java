package com.da0hn.user.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTransaction {

  @Id
  private Long id;
  private Long idUser;
  private Double amount;
  private LocalDateTime date;


}
