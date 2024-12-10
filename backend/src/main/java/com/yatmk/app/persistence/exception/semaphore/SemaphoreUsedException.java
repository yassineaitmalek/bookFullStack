package com.yatmk.app.persistence.exception.semaphore;

import com.yatmk.app.persistence.exception.config.TooManyRequestsException;

public class SemaphoreUsedException extends TooManyRequestsException {

  public SemaphoreUsedException() {
    super("this Semaphore is already used by another process wait intil it is done");

  }

  public SemaphoreUsedException(String message) {
    super(message);

  }

}
