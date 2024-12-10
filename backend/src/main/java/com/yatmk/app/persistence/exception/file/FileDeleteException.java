package com.yatmk.app.persistence.exception.file;

import com.yatmk.app.persistence.exception.config.ServerSideException;

public class FileDeleteException extends ServerSideException {

  /**
   * @param message
   */
  public FileDeleteException() {
    super("error while deleting a file");

  }

}
