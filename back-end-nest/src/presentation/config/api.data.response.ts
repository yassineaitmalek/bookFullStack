import { ApiProperty } from "@nestjs/swagger";

export class ApiDataResponse<T> {

  @ApiProperty({ type: String, })
  status: string;

  @ApiProperty({ type: Number, })
  httpStatus: number;

  @ApiProperty({ type: String, })
  date: string;

  @ApiProperty({ type: String, })
  time: string;

  @ApiProperty({ type: String, })
  zone: string = Intl.DateTimeFormat().resolvedOptions().timeZone;

  @ApiProperty()
  data: T;

  constructor(data: T, httpStatus: number, status: string) {
    const dateTime: Date = new Date();
    this.data = data;
    this.httpStatus = httpStatus;
    this.status = status;
    this.date = dateTime.toISOString().split('T')[0];
    this.time = dateTime.toISOString().split('T')[1].split('.')[0];
    this.zone = Intl.DateTimeFormat().resolvedOptions().timeZone;
  }
}
