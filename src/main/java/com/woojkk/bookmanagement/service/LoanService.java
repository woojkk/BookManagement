package com.woojkk.bookmanagement.service;

import com.woojkk.bookmanagement.config.JwtProvider;
import com.woojkk.bookmanagement.dto.LoanDto;
import com.woojkk.bookmanagement.dto.LoanHistoryDto;
import com.woojkk.bookmanagement.mapper.BookMapper;
import com.woojkk.bookmanagement.mapper.LoanMapper;
import com.woojkk.bookmanagement.vo.UserVo;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

  private final LoanMapper loanMapper;
  private final BookMapper bookMapper;
  private final JwtProvider jwtProvider;


  public void loanBook(String token, Long bookId) {
    if (!jwtProvider.validateToken(token)) {
      throw new RuntimeException("토근 유효기간이 만료되었습니다. 다시 로그인해주세요.");
    }

    if (bookMapper.findBook(bookId) < 1) {
      throw new RuntimeException("등록되지 않은 도서입니다.");
    }

    UserVo userVo = jwtProvider.getUserVo(token);

    Boolean checkState = loanMapper.checkState(bookId, userVo.getUserId());

    if (checkState == null || !checkState) {
      LoanDto newLoanDto = LoanDto.builder()
          .userId(userVo.getUserId())
          .bookId(bookId)
          .loanDate(LocalDateTime.now())
          .returnDate(LocalDateTime.now().plusWeeks(2))
          .state(true)
          .build();

      loanMapper.loanBook(newLoanDto);
    } else {
      throw new RuntimeException("이미 대여중인 도서입니다.");
    }
  }

  public List<LoanHistoryDto> loanHistory(String token, Long bookId) {
    return loanMapper.loanHistory(bookId);
  }
}
