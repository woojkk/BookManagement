package com.woojkk.bookmanagement.controller;

import com.woojkk.bookmanagement.dto.BookDto;
import com.woojkk.bookmanagement.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<String> registrationBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                               @RequestBody BookDto bookDto) {

    bookService.registrationBook(token, bookDto);

    return ResponseEntity.ok("도서 등록 완료.");
  }

  @Operation(summary = "도서 수정")
  @PutMapping("/book/{bookId}")
  public ResponseEntity<String> updatedBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
                          @PathVariable Long bookId,
                          @RequestBody BookDto bookDto) {
    bookService.updateBook(token, bookId, bookDto);

    return ResponseEntity.ok("도서 수정 완료.");
  }

  @Operation(summary = "도서 삭제")
  @DeleteMapping("/book/{bookId}")
  public ResponseEntity<String> deleteBook(@RequestHeader(name = "X-AUTH-TOKEN") String token,
      @PathVariable Long bookId) {
    bookService.deleteBook(token, bookId);

    return ResponseEntity.ok("도서 삭제 완료.");
  }

  @Operation(summary = "도서 조회")
  @GetMapping("/book/search")
  public List<BookDto> searchAllBook() {
    return bookService.searchAllBook();
  }
}
