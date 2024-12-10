package com.yatmk.app.infrastructure.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.yatmk.app.persistence.dto.BookDTO;
import com.yatmk.app.persistence.dto.BookSearchDTO;
import com.yatmk.app.persistence.dto.BookUpdateDTO;
import com.yatmk.app.persistence.exception.config.ServerSideException;
import com.yatmk.app.persistence.models.local.Book;
import com.yatmk.app.persistence.models.local.attachement.Content;
import com.yatmk.app.persistence.models.local.attachement.Cover;
import com.yatmk.app.persistence.repositories.local.BookRepository;
import com.yatmk.app.persistence.specification.BookSpecification;

import lombok.RequiredArgsConstructor;

@Validated
@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  private final BookSpecification bookSpecification;

  private final AttachementService attachementService;

  private final ModelMapper modelMapper;

  public Page<Book> search(BookSearchDTO bookSearchDTO, Pageable pageable) {
    return bookRepository.findAll(bookSpecification.searchRequest(bookSearchDTO), pageable);
  }

  public Book get(Long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new ServerSideException("book does not exist"));
  }

  public Book createBook(BookDTO bookDTO) {

    Book book = modelMapper.map(bookDTO, Book.class);

    Cover cover = new Cover();
    cover.setBook(book);
    book.setCover(cover);
    attachementService.uploadAttachement(bookDTO.getCoverFile(), cover);

    Content content = new Content();
    content.setBook(book);
    book.setContent(content);

    attachementService.uploadAttachement(bookDTO.getContentFile(), content);

    return bookRepository.save(book);
  }

  public void delete(Long id) {

    Book book = get(id);
    attachementService.deleteAttachement(book.getContent());
    attachementService.deleteAttachement(book.getCover());
    bookRepository.delete(book);

  }

  public Book update(Long id, BookUpdateDTO bookUpdateDTO) {

    Book old = get(id);
    modelMapper.map(bookUpdateDTO, old);
    return bookRepository.save(old);

  }

}
