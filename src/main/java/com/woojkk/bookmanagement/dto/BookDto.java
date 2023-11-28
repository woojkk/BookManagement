package com.woojkk.bookmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BookDto {
  private Long bookId;
  private String genre;
  private String bookName;
  private String author;
  private int publicationYear;
}
