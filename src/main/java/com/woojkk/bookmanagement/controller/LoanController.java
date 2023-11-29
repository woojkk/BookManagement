package com.woojkk.bookmanagement.controller;

import com.woojkk.bookmanagement.dto.LoanHistoryDto;
import com.woojkk.bookmanagement.service.LoanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController {

  private final LoanService loanService;

  /**
   * 도서 대출
   */
  @PostMapping("/Loan/{bookId}")
  public void loanBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                       @PathVariable Long bookId) {
    loanService.loanBook(token, bookId);
  }

  /**
   * 대출 이력 및 카운트
   *
   */
  @GetMapping("/loan/history/{bookId}")
  public List<LoanHistoryDto> loanHistoryAndCount(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                          @PathVariable Long bookId) {
    return loanService.loanHistoryAndCount(token, bookId);
  }
}
