package com.yatmk.app.persistence.exception.file;

import com.yatmk.app.persistence.exception.config.ServerSideException;

public class FileDownloadException extends ServerSideException {

  /**
   * @param message
   */
  public FileDownloadException() {
    super("error could not Download File");

  }

}
