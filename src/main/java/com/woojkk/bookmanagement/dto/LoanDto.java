package com.woojkk.bookmanagement.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LoanDto {
  private Long loanId;
  private Long userId;
  private Long bookId;
  private LocalDateTime loanDate;
  private LocalDateTime returnDate;
  private boolean state;

}
