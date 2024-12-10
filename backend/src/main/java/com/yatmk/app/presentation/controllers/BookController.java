package com.yatmk.app.presentation.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatmk.app.infrastructure.services.BookService;
import com.yatmk.app.persistence.dto.BookDTO;
import com.yatmk.app.persistence.dto.BookSearchDTO;
import com.yatmk.app.persistence.dto.BookUpdateDTO;
import com.yatmk.app.persistence.models.local.Book;
import com.yatmk.app.persistence.presentation.ApiDataResponse;
import com.yatmk.app.presentation.config.AbstractController;
import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController implements AbstractController {

  private final BookService bookService;

  @PutMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  public ResponseEntity<ApiDataResponse<Book>> create(@ModelAttribute BookDTO bookDTO) {
    return create(() -> bookService.createBook(bookDTO));
  }

  @GetMapping
  public ResponseEntity<ApiDataResponse<Page<Book>>> search(@ModelAttribute BookSearchDTO bookSearchDTO,
      Pageable pageable) {
    return ok(() -> bookService.search(bookSearchDTO, pageable));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ApiDataResponse<Book>> update(@PathVariable Long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
    return ok(() -> bookService.update(id, bookUpdateDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    return noContent(() -> bookService.delete(id));
  }

}
