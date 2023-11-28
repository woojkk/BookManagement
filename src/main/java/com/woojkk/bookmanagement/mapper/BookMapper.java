package com.woojkk.bookmanagement.mapper;

import com.woojkk.bookmanagement.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

  int registration(BookDto bookDto);

  int checkAuthorAndBookName(String author, String bookName);

  void updateBook(BookDto bookDto);

  void deleteBook(Long bookId);
}
