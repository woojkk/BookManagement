package com.woojkk.bookmanagement.mapper;

import com.woojkk.bookmanagement.dto.BookDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

  int saveBook(BookDto bookDto);

  int findByAuthorAndBookName(String author, String bookName);

  void updateBook(BookDto bookDto);

  void deleteBook(Long bookId);

  List<BookDto> findAllBook();

  int findBook(Long bookId);
}
