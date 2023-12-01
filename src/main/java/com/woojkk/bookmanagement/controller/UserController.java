package com.woojkk.bookmanagement.controller;

import com.woojkk.bookmanagement.dto.UserDto;
import com.woojkk.bookmanagement.service.UserService;
import com.woojkk.bookmanagement.vo.LoginForm;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @Operation(summary = "회원 가입")
  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> signupUser(@Valid @RequestBody UserDto userDto) {
    userService.signup(userDto);

    return ResponseEntity.ok("회원 가입 완료.");
  }

  @Operation(summary = "로그인")
  @PostMapping("/login")
  public String loginUser(@RequestBody LoginForm loginForm) {
    return userService.login(loginForm);
  }
}
