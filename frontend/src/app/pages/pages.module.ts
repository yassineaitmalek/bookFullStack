import { NgModule } from '@angular/core';
import { BooksComponent } from './books/books.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [BooksComponent],
  imports: [CommonModule, HttpClientModule],

  exports: [],
  providers: [],
  bootstrap: [],
})
export class PagesModule {}
