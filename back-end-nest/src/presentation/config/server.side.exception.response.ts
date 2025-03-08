export class ServerSideExceptionResponse {

  message: string;
  status: string;
  httpStatus: number;
  path: string;
  date: string;
  time: string;
  zone: string;

  constructor(message: string, status: string, httpStatus: number, path: string) {
    const dateTime: Date = new Date();
    this.message = message;
    this.status = status;
    this.httpStatus = httpStatus;
    this.path = path;
    this.date = dateTime.toISOString().split('T')[0];
    this.time = dateTime.toISOString().split('T')[1].split('.')[0];
    this.zone = Intl.DateTimeFormat().resolvedOptions().timeZone;
  }
}
