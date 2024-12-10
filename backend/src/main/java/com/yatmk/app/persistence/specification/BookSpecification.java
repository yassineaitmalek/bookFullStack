package com.yatmk.app.persistence.specification;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.yatmk.app.persistence.dto.BookSearchDTO;
import com.yatmk.app.persistence.models.local.Book;
import com.yatmk.app.persistence.models.local.Book_;

@Component
public class BookSpecification implements AbstractSpecification {

  private Specification<Book> hasAuthor(String author) {
    return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Book_.AUTHOR), author);
  }

  private Specification<Book> hasCountry(String country) {
    return (root, query, builder) -> builder.equal(root.get(Book_.COUNTRY), country);
  }

  private Specification<Book> hasLanguage(String language) {
    return (root, query, builder) -> builder.equal(root.get(Book_.LANGUAGE), language);
  }

  private Specification<Book> hasPages(Long pages) {
    return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Book_.PAGES), pages);
  }

  private Specification<Book> hasTitle(String title) {
    return (root, query, builder) -> builder.equal(root.get(Book_.TITLE), title);
  }

  private Specification<Book> hasYear(Long year) {
    return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Book_.YEAR), year);
  }

  public Specification<Book> searchRequest(BookSearchDTO bookSearchDTO) {

    return Optional.ofNullable(bookSearchDTO)
        .map(this::searchRequestImpl)
        .orElseGet(this::unitSpecification);

  }

  public Specification<Book> searchRequestImpl(BookSearchDTO bookSearchDTO) {

    return Stream.of(
        transformer(bookSearchDTO.getAuthor(), this::hasAuthor),
        transformer(bookSearchDTO.getCountry(), this::hasCountry),
        transformer(bookSearchDTO.getLanguage(), this::hasLanguage),
        transformer(bookSearchDTO.getPages(), this::hasPages),
        transformer(bookSearchDTO.getTitle(), this::hasTitle),
        transformer(bookSearchDTO.getYear(), this::hasYear))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .reduce(Specification.where(distinct()), Specification::and);

  }

}
