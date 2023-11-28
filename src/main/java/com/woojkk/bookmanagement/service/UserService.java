package com.woojkk.bookmanagement.service;

import com.woojkk.bookmanagement.config.AES256Util;
import com.woojkk.bookmanagement.config.JwtProvider;
import com.woojkk.bookmanagement.dto.UserDto;
import com.woojkk.bookmanagement.mapper.UserMapper;
import com.woojkk.bookmanagement.vo.LoginForm;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
  private static final Pattern CONTACT_NUMBER_RULE =
      Pattern.compile("^01([0|1|6|7|8|9])-?(\\d{3,4})-?(\\d{4})$");

  private final UserMapper userMapper;
  private final JwtProvider jwtProvider;

  @Transactional
  public void signup(UserDto userDto) {

    if (isDuplicatedNickname(userDto.getNickname())) {
      throw new IllegalStateException("중복된 닉네임입니다.");
    }

    if (!CONTACT_NUMBER_RULE.matcher(userDto.getContactNumber()).matches()) {
      throw new IllegalArgumentException("전화번호 형식이 잘못되었습니다.");
    }

    UserDto encryptedUserDto = UserDto.builder()
        .nickname(userDto.getNickname())
        .password(AES256Util.encrypt(userDto.getPassword()))
        .contactNumber(userDto.getContactNumber())
        .role(userDto.isRole())
        .build();

    int saveCount = userMapper.save(encryptedUserDto);


    if (saveCount != 1) {
      throw new IllegalStateException("회원가입 중 오류가 발생하였습니다.");
    }
  }

  public boolean isDuplicatedNickname(String nickname) {
    return userMapper.nicknameCheck(nickname) == 1;
  }

  public String login(LoginForm loginForm) {

    LoginForm newLoginForm = LoginForm.builder()
        .nickname(loginForm.getNickname())
        .password(AES256Util.encrypt(loginForm.getPassword())).build();

    UserDto userDto = userMapper.login(newLoginForm);

    return jwtProvider.createToken(userDto.getNickname(), userDto.getUserId());
  }
}
