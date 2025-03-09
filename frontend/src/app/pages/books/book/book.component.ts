import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../../../shared/api/books/model/book';
import { AttachementControllerService } from '../../../shared/api/books';

@Component({
  standalone: true,
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent implements OnInit {

  @Input() book: Book = {} as Book;

  constructor(private attachmentService: AttachementControllerService) {

  }


  streamImage(id: number) {
    return `http://localhost:8080/book-service/api/attachement/stream/${id}`;
  }




  ngOnInit(): void { }


}
