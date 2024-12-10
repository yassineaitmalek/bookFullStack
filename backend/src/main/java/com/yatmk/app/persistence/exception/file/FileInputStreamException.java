package com.yatmk.app.persistence.exception.file;

import com.yatmk.app.persistence.exception.config.ServerSideException;

public class FileInputStreamException extends ServerSideException {

  /**
   * @param message
   */
  public FileInputStreamException() {
    super("error while getting the file inputstream");

  }

}
