import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';
import { BookService } from '../../shared/api/books/api/book.service';
import { ToastService } from '../../services/toast.service';
import { Book } from '../../shared/api/books/model/book';
import { BookComponent } from './book/book.component';

@Component({
  standalone: true,
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrl: './books.component.css',
  imports: [CommonModule, BookComponent],
})
export class BooksComponent implements OnInit {
  constructor(
    private booksService: BookService,
    private toastService: ToastService
  ) { }

  size: number = 4;

  page: number = 0;

  books: Book[] = [];



  ngOnInit(): void {
    this.toastService.onSucess('heeey', '');
    this.booksService
      .search(
        {},
        {
          page: this.page,
          size: this.size,

        }
      )
      .pipe()
      .subscribe(
        (res) => {
          this.books = res?.data?.content || [];

          this.page++;
        },
        (err) => {
          console.error(err);
        }
      )

    console.log(this.books);

  }
}
