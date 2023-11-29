package com.woojkk.bookmanagement.mapper;

import com.woojkk.bookmanagement.dto.LoanDto;
import com.woojkk.bookmanagement.dto.LoanHistoryDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoanMapper {

  void loanBook(LoanDto loanDto);
  void returnBook(Long bookId, Long userId);
  List<LoanDto> findAllLoan();
  Boolean checkState(Long bookId, Long userId);

  List<LoanHistoryDto> loanHistory(Long bookId);
}
