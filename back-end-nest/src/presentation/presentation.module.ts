import { Module } from '@nestjs/common';
import { BookController } from './controllers';

@Module({
  imports: [],
  controllers: [BookController],
  providers: [],
})
export class PresentationModule { }
