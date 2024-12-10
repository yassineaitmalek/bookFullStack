import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BooksService } from '../../services/books.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrl: './books.component.css',
})
export class BooksComponent implements OnInit {
  constructor(private booksService: BooksService) {}

  ngOnInit(): void {
    this.booksService.getBooks();
  }
}
