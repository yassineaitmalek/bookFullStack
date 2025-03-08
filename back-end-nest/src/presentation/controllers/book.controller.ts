import { Body, Controller, Delete, Get, HttpCode, Param, Post, Query } from '@nestjs/common';
import { AbstractController } from '../config/abstract.controller';
import { ApiDataResponse } from '../config/api.data.response';

import { BookEntity } from 'src/persistence/models/local/book.entity';
import { BookService } from 'src/infrastructure/services/book.service';
import { Page } from 'src/persistence/models/config/page.interface';
import { ApiBody, ApiExtraModels, ApiQuery, ApiResponse } from '@nestjs/swagger';
import { BookDTO } from 'src/persistence/dto/book.dto';

@Controller('api/books')
@ApiExtraModels(ApiDataResponse<Page<BookEntity>>, ApiDataResponse<BookEntity>, ApiDataResponse<string>, BookDTO, BookEntity, Page,)
export class BookController extends AbstractController {

  constructor(private readonly bookService: BookService) {
    super();
  }


  @Get()
  @HttpCode(200)
  @ApiQuery({ name: 'page', required: false, description: 'page', type: Number })
  @ApiQuery({ name: 'size', required: false, description: 'size', type: Number })
  @ApiResponse({ status: 200, type: ApiDataResponse<Page<BookEntity>>, })
  getBooks(@Query('page') page: number, @Query('size') size: number): Promise<ApiDataResponse<Page<BookEntity>>> {
    return this.bookService.getBooks(page, size)
      .then((data: Page<BookEntity>) => this.ok(data));

  }


  @Post()
  @HttpCode(201)
  @ApiBody({ type: BookDTO })
  @ApiResponse({ status: 201, type: ApiDataResponse<BookEntity>, })
  addBook(@Body() bookDTO: BookDTO): Promise<ApiDataResponse<BookEntity>> {
    return this.bookService.addBook(bookDTO)
      .then((data: BookEntity) => this.ok(data));

  }

  @Delete(':id')
  @HttpCode(204)
  @ApiResponse({ status: 204, type: ApiDataResponse<string>, })
  deleteBook(@Param('id') id: number): Promise<ApiDataResponse<string>> {
    return this.bookService.deleteBook(id)
      .then(() => this.noContent());
  }


}
