
import { Global, Module } from '@nestjs/common';
import { BookService } from './services/book.service';


@Global()
@Module({
  imports: [],
  providers: [BookService],
  exports: [BookService],
})
export class InfrastructureModule { }
