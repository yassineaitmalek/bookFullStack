import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookControllerService } from '../shared/api/books/api/bookController.service';

@Injectable({
  providedIn: 'root',
})
export class BooksService {
  constructor(private bookControllerService: BookControllerService) {}

  getBooks() {
    this.bookControllerService
      .search(
        {},
        {
          page: 0,
          size: 1000,
        }
      )
      .subscribe(
        (res) => {
          res.data?.content?.forEach((book) => {
            console.log(book.id);
          });
        },
        (err) => {
          console.error(err);
        }
      );
  }
}
