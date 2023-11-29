package com.woojkk.bookmanagement.config;

import com.woojkk.bookmanagement.dto.LoanDto;
import com.woojkk.bookmanagement.mapper.LoanMapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoanScheduler {

  private final LoanMapper loanMapper;

  @Scheduled(cron = "0 0 0 * * *")
  public void autoReturnBooks() {
    List<LoanDto> loanList = loanMapper.findAllLoan();

    loanList.forEach(x -> {
      boolean after = x.getReturnDate().isBefore(LocalDateTime.now());

      if (after) {
        loanMapper.returnBook(x.getBookId(), x.getUserId());
      }
    });

    log.debug("반납 기한 체크");
  }
}
