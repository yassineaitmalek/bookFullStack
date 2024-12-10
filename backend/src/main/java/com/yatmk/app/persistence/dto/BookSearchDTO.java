package com.yatmk.app.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchDTO {

  private String author;

  private String country;

  private String language;

  private String link;

  private Long pages;

  private String title;

  private Long year;

}
