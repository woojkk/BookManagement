package com.woojkk.bookmanagement.service;

import com.woojkk.bookmanagement.dto.UserDto;
import com.woojkk.bookmanagement.mapper.UserMapper;
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

  @Transactional
  public void signup(UserDto userDto) {

    if (userDto.getNickname() == null || userDto.getPassword() == null
        || userDto.getContactNumber() == null) {
      throw new NullPointerException("필수 입력사항을 모두 입력해주세요.");
    }
    boolean duplicatedId = isDuplicatedNickname(userDto.getNickname());

    if (duplicatedId) {
      throw new IllegalStateException("중복된 닉네임입니다.");
    }

    if (!CONTACT_NUMBER_RULE.matcher(userDto.getContactNumber()).matches()) {
      throw new IllegalArgumentException("전화번호 형식이 잘못되었습니다.");
    }

    int saveCount = userMapper.save(userDto);

    if (saveCount != 1) {
      throw new IllegalStateException("회원가입 메서드를 확인해주세요.\n" + "UserDto : " + userDto);
    }
  }

  public boolean isDuplicatedNickname(String nickname) {
    return userMapper.nicknameCheck(nickname) == 1;
  }
}
