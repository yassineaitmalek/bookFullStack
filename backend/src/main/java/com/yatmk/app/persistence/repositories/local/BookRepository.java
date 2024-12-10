package com.yatmk.app.persistence.repositories.local;

import org.springframework.stereotype.Repository;

import com.yatmk.app.persistence.models.local.Book;
import com.yatmk.app.persistence.repositories.config.AbstractRepository;

@Repository
public interface BookRepository extends AbstractRepository<Book, Long> {

}
