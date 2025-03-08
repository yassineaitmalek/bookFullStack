import { HttpException } from "@nestjs/common";
export class ServerSideException extends HttpException {
  constructor(message: string) {
    super(message, 500);

  }

  public static of(message: string): ServerSideException {
    return new ServerSideException(message);
  }
}
