package com.yatmk.app.persistence.exception.file;

import com.yatmk.app.persistence.exception.config.ServerSideException;

public class FileUploadException extends ServerSideException {

  /**
   * @param message
   */
  public FileUploadException() {
    super("error could not upload File");

  }

}
