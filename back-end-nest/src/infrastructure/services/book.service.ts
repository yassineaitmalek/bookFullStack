import { Injectable } from "@nestjs/common";
import { BookDTO } from "src/persistence/dto/book.dto";
import { Page } from "src/persistence/models/config/page.interface";
import { BookEntity } from "src/persistence/models/local/book.entity";
import { BookRepository } from "src/persistence/repositories/book.repository";



@Injectable()
export class BookService {

  constructor(private readonly bookRepository: BookRepository) { }


  async addBook(bookDTO: BookDTO): Promise<BookEntity> {
    const book: BookEntity = new BookEntity();
    book.author = bookDTO.author;
    book.country = bookDTO.country;
    book.language = bookDTO.language;
    book.pages = bookDTO.pages;
    book.title = bookDTO.title;
    book.year = bookDTO.year;
    return this.bookRepository.save(book);
  }

  async getBooks(page: number, size: number): Promise<Page<BookEntity>> {
    return this.bookRepository.findPaginated(page, size);
  }

  async deleteBook(id: number): Promise<void> {

    this.bookRepository.delete(id);

  }



}