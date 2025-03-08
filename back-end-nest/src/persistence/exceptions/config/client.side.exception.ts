import { HttpException } from "@nestjs/common";



export class ClientSideException extends HttpException {


  constructor(message: string) {
    super(message, 400);

  }

  public static of(message: string): ClientSideException {
    return new ClientSideException(message);
  }

}
