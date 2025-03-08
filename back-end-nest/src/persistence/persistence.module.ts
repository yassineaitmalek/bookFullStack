
import { Global, Module } from '@nestjs/common';
import { BookRepository } from './repositories/book.repository';
import { TypeOrmModule } from '@nestjs/typeorm';
import { BookEntity } from './models/local/book.entity';
import { DataBaseConfig } from './config/database.providers';

@Global()
@Module({
  imports: [DataBaseConfig.getDatabaseConfig(), TypeOrmModule.forFeature([BookEntity])],
  providers: [BookRepository],
  exports: [TypeOrmModule, BookRepository],
})
export class PersistenceModule { }
