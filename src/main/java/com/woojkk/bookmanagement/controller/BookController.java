package com.woojkk.bookmanagement.controller;

import com.woojkk.bookmanagement.dto.BookDto;
import com.woojkk.bookmanagement.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @Operation(summary = "도서 등록")
  @PostMapping("/book")
  @ResponseStatus(HttpStatus.CREATED)
  public void registrationBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                               @RequestBody BookDto bookDto) {

    bookService.registrationBook(token, bookDto);
  }

  @Operation(summary = "도서 수정")
  @PutMapping("/book/{bookId}")
  public void updatedBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                          @PathVariable Long bookId,
                          @RequestBody BookDto bookDto) {
    bookService.updateBook(token, bookId, bookDto);
  }

  @Operation(summary = "도서 삭제")
  @DeleteMapping("/book/{bookId}")
  public void deleteBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
      @PathVariable Long bookId) {
    bookService.deleteBook(token, bookId);
  }

  @Operation(summary = "도서 조회")
  @GetMapping("/book/search")
  public List<BookDto> searchAllBook() {
    return bookService.searchAllBook();
  }
}
