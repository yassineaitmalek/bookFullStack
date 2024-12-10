package com.yatmk.app.persistence.exception.file;

import com.yatmk.app.persistence.exception.config.ServerSideException;

public class FileUnStreamableException extends ServerSideException {

  /**
   * @param message
   */
  public FileUnStreamableException() {
    super("error the file is unstreamable");

  }

}
