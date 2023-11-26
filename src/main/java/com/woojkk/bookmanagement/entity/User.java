package com.woojkk.bookmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class User {
  private Long userId;
  private String nickname;
  private String password;
  private String contactNumber;
  private boolean role; // true : 관리자, false : 사용자

}
