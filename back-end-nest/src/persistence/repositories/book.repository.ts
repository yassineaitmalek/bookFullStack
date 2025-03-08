import { DataSource, Repository } from "typeorm";
import { BookEntity } from "../models/local/book.entity";
import { Injectable } from "@nestjs/common";
import { Page } from "../models/config/page.interface";

@Injectable()
export class BookRepository extends Repository<BookEntity> {

  constructor(private readonly dataSource: DataSource) {
    super(BookEntity, dataSource.createEntityManager());
  }

  async findPaginated(page: number, size: number): Promise<Page<BookEntity>> {
    const [data, total] = await this.findAndCount({
      skip: (page - 1) * size, // Offset calculation
      take: size, // Limit for each page
      order: { id: 'ASC' }, // Optional sorting
    });
    const totalPages = Math.ceil(total / size);
    return new Page(data, total, totalPages, page, size);
  }

}