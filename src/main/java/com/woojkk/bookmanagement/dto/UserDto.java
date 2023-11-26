package com.woojkk.bookmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
  private Long id;
  private String nickname;
  private String password;
  private String contactNumber;
  private boolean role;
}
