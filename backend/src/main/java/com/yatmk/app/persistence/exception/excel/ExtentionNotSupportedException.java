package com.yatmk.app.persistence.exception.excel;

import com.yatmk.app.persistence.exception.config.ServerSideException;

public class ExtentionNotSupportedException extends ServerSideException {

  public ExtentionNotSupportedException() {
    super("the extention is not supproted");

  }

  public ExtentionNotSupportedException(String message) {
    super(message);

  }
}
