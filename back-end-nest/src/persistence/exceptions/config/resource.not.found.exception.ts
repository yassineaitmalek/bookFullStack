import { HttpException } from "@nestjs/common";

export class ResourceNotFoundException extends HttpException {
  constructor(message: string) {
    super(message, 404);

  }

  public static of(message: string): ResourceNotFoundException {
    return new ResourceNotFoundException(message);
  }
}
