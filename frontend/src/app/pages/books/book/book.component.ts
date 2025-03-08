import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../../../shared/api/books/model/book';

@Component({
  standalone: true,
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent implements OnInit {

  @Input() book: Book = {} as Book;




  ngOnInit(): void { }


}
