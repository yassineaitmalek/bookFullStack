package com.yatmk.app.persistence.exception.file;

import com.yatmk.app.persistence.exception.config.ResourceNotFoundException;

public class FileNotFoundException extends ResourceNotFoundException {

  /**
   * @param message
   */
  public FileNotFoundException() {
    super("error File does not exist");

  }

}
