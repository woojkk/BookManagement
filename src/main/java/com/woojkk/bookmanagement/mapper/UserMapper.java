package com.woojkk.bookmanagement.mapper;

import com.woojkk.bookmanagement.dto.UserDto;
import com.woojkk.bookmanagement.vo.LoginForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  int save(UserDto userDto);
  int nicknameCheck(String name);
  UserDto checkRole(Long userId);
  UserDto login(LoginForm loginForm);
}
