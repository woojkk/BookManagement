package com.woojkk.bookmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserDto {
  private Long userId;
  @NotBlank(message = "닉네임을 입력해주세요.")
  private String nickname;
  @NotBlank(message = "비밀번호를 입력해주세요.")
  private String password;
  private String contactNumber;
  private boolean role;
}
