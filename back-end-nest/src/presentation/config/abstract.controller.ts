import { Response } from 'express';
import { ApiDataResponse } from './api.data.response';


export abstract class AbstractController {
  ok<T>(data: T): ApiDataResponse<T> {
    return new ApiDataResponse(data, 200, 'OK');
  }

  create<T>(data: T): ApiDataResponse<T> {
    return new ApiDataResponse(data, 201, 'CREATED');
  }

  noContent(): ApiDataResponse<string> {

    return new ApiDataResponse("Done", 204, 'NO_CONTENT');
  }

  async<T>(response: Response, action: () => void, data: T): Response {
    action();
    return response.status(202).json(new ApiDataResponse(data, 202, 'ACCEPTED'));
  }

  download(response: Response, fileName: string, fileBuffer: Buffer): Response {
    response.setHeader('Content-Type', 'application/octet-stream');
    response.setHeader('Content-Disposition', `attachment; filename=${fileName}`);
    response.setHeader('Content-Length', fileBuffer.length.toString());
    return response.status(200).send(fileBuffer);
  }

  downloadLarge(response: Response, fileName: string, contentLength: number, streamingResponseBody: NodeJS.ReadableStream,): void {
    response.setHeader('Content-Type', 'application/octet-stream');
    response.setHeader('Content-Disposition', `attachment; filename=${fileName}`,);
    response.setHeader('Content-Length', contentLength.toString());
    streamingResponseBody.pipe(response);
  }

  partial(response: Response, contentType: string, contentRange: string, contentLength: number, fileBuffer: Buffer,): Response {
    response.setHeader('Content-Type', contentType);
    response.setHeader('Accept-Ranges', 'bytes');
    response.setHeader('Content-Range', contentRange);
    response.setHeader('Content-Length', contentLength.toString());
    return response.status(206).send(fileBuffer);
  }

}
