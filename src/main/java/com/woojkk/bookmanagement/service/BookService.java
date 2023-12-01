package com.woojkk.bookmanagement.service;

import com.woojkk.bookmanagement.config.JwtProvider;
import com.woojkk.bookmanagement.dto.BookDto;
import com.woojkk.bookmanagement.dto.UserDto;
import com.woojkk.bookmanagement.mapper.BookMapper;
import com.woojkk.bookmanagement.mapper.UserMapper;
import com.woojkk.bookmanagement.vo.UserVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookMapper bookMapper;
  private final UserMapper userMapper;
  private final JwtProvider jwtProvider;

  @Transactional
  public void registrationBook(String token, BookDto bookDto) {

    if (!jwtProvider.validateToken(token)) {
      throw new RuntimeException("토근 유효기간이 만료되었습니다. 다시 로그인해주세요.");
    }

    if (!roleCheck(token)) {
      throw new RuntimeException("권한이 없습니다.");
    }

    int checkAuthorAndBookName = bookMapper.findByAuthorAndBookName(bookDto.getAuthor(), bookDto.getBookName());

    if (checkAuthorAndBookName >= 1) {
      throw new IllegalStateException("이미 등록된 도서입니다.");
    }

    int registrationCount = bookMapper.saveBook(bookDto);

    if (registrationCount != 1) {
      throw new IllegalStateException("도서 등록 중 오류가 발생하였습니다.");
    }
  }

  @Transactional
  public void updateBook(String token, Long bookId, BookDto bookDto) {
    if (!jwtProvider.validateToken(token)) {
      throw new RuntimeException("토근 유효기간이 만료되었습니다. 다시 로그인해주세요.");
    }

    if (!roleCheck(token)) {
      throw new RuntimeException("권한이 없습니다.");
    }

    BookDto newBookDto = BookDto.builder()
        .bookId(bookId)
        .bookName(bookDto.getBookName())
        .author(bookDto.getAuthor())
        .genre(bookDto.getGenre())
        .publicationYear(bookDto.getPublicationYear())
        .build();

    bookMapper.updateBook(newBookDto);

  }

  public boolean roleCheck(String token) {
    UserVo userVo = jwtProvider.getUserVo(token);

    UserDto userdto = userMapper.checkRole(userVo.getUserId());

    return userdto.isRole();
  }

  @Transactional
  public void deleteBook(String token, Long bookId) {
    if (!jwtProvider.validateToken(token)) {
      throw new RuntimeException("토근 유효기간이 만료되었습니다. 다시 로그인해주세요.");
    }

    if (!roleCheck(token)) {
      throw new RuntimeException("권한이 없습니다.");
    }

    bookMapper.deleteBook(bookId);
  }

  public List<BookDto> searchAllBook() {
    return bookMapper.findAllBook();
  }
}
