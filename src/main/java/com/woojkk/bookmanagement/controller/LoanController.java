package com.woojkk.bookmanagement.controller;

import com.woojkk.bookmanagement.dto.LoanHistoryDto;
import com.woojkk.bookmanagement.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
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

  @Operation(summary = "도서 대출")
  @PostMapping("/Loan/{bookId}")
  public void loanBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                       @PathVariable Long bookId) {
    loanService.loanBook(token, bookId);
  }

  @Operation(summary = "대출 이력 조회")
  @GetMapping("/loan/history/{bookId}")
  public List<LoanHistoryDto> loanHistory(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                          @PathVariable Long bookId) {
    return loanService.loanHistory(token, bookId);
  }
}
