import { ApiProperty } from "@nestjs/swagger";

export class Page<T> {




  @ApiProperty()
  total: number;

  @ApiProperty()
  totalPages: number;

  @ApiProperty()
  currentPage: number;

  @ApiProperty()
  pageSize: number;


  @ApiProperty()
  data: T[];

  constructor(data: T[], total: number, totalPages: number, currentPage: number, pageSize: number) {
    this.data = data;
    this.total = total;
    this.totalPages = totalPages;
    this.currentPage = currentPage;
    this.pageSize = pageSize;
  }
}
