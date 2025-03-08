import { HttpException } from "@nestjs/common";

export class TooManyRequestsException extends HttpException {
  constructor(message: string) {
    super(message, 429);

  }

  public static of(message: string): TooManyRequestsException {
    return new TooManyRequestsException(message);
  }
}
