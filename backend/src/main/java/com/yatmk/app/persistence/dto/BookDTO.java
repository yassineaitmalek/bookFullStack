package com.yatmk.app.persistence.dto;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

  private String author;

  private String country;

  private String language;

  private String link;

  private Long pages;

  private String title;

  private Long year;

  @NotNull
  private MultipartFile coverFile;

  @NotNull
  private MultipartFile contentFile;
}
