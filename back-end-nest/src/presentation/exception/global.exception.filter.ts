import { ArgumentsHost, Catch, ExceptionFilter, HttpException, HttpStatus } from '@nestjs/common';
import { Request, Response } from 'express';
import { Optional } from 'typescript-optional';
import { ServerSideExceptionResponse } from '../config/server.side.exception.response';

@Catch(Error)
export class GlobalExceptionFilter implements ExceptionFilter {


  catch(exception: Error, host: ArgumentsHost) {
    const ctx = host.switchToHttp();
    const response = ctx.getResponse<Response>();
    const request = ctx.getRequest<Request>();
    const status = this.getStatusCode(exception);
    const statusName = this.getStatusName(status);
    this.logStackTrace(exception, status);
    response.status(status).json(new ServerSideExceptionResponse(exception.message, statusName, status, request.url));

  }

  getStatusCode(exception: Error): number {

    return Optional.ofNullable(exception)
      .filter((ex) => ex instanceof HttpException)
      .map((ex) => ex as HttpException)
      .map((ex) => ex.getStatus())
      .orElseGet(() => 500);

  }


  getStatusName(status: number): string {
    return Optional.ofNullable(HttpStatus)
      .map(httpStatus => Object.keys(httpStatus))
      .map(keys => keys.find((key) => HttpStatus[key as keyof typeof HttpStatus] === status))
      .orElseGet(() => 'Unknown Status');
  }

  logStackTrace(exception: Error, status: number): void {
    if (500 === status) {
      console.error(exception.stack);
    }
  }

}