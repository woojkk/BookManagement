package com.woojkk.bookmanagement.controller;

import com.woojkk.bookmanagement.dto.UserDto;
import com.woojkk.bookmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public void signupUser(@RequestBody UserDto userDto) {
    userService.signup(userDto);
  }
}
