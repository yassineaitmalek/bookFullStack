package com.yatmk.app.presentation.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.yatmk.app.persistence.exception.config.ClientSideException;
import com.yatmk.app.persistence.exception.config.ResourceNotFoundException;
import com.yatmk.app.persistence.exception.config.ServerSideException;
import com.yatmk.app.persistence.exception.config.TooManyRequestsException;
import com.yatmk.app.persistence.presentation.ServerSideExceptionResponse;
import com.yatmk.app.presentation.config.AbstractController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ServerSideExceptionHandler implements AbstractController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ServerSideExceptionResponse> handleExceptions(Exception e, WebRequest request) {
    log.error(e.getMessage(), e);
    return internalException(e, request);
  }

  @ExceptionHandler(value = { ServerSideException.class })
  public ResponseEntity<ServerSideExceptionResponse> handleServerSideException(ServerSideException e,
      WebRequest request) {

    log.error(e.getMessage());
    return internalException(e, request);

  }

  @ExceptionHandler(value = { ClientSideException.class })
  public ResponseEntity<ServerSideExceptionResponse> handleClientSideException(ClientSideException e,
      WebRequest request) {

    log.error(e.getMessage());
    return badRequest(e, request);

  }

  @ExceptionHandler(value = { TooManyRequestsException.class })
  public ResponseEntity<ServerSideExceptionResponse> handleTooManyRequestsException(TooManyRequestsException e,
      WebRequest request) {

    log.error(e.getMessage());
    return tooManyRequests(e, request);

  }

  @ExceptionHandler(value = { ResourceNotFoundException.class })
  public ResponseEntity<ServerSideExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e,
      WebRequest request) {

    log.error(e.getMessage());
    return notFound(e, request);

  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ServerSideExceptionResponse> handleValidationExceptions(ConstraintViolationException e,
      WebRequest request) {
    log.error(e.getMessage());
    return badRequest(e, request);

  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ServerSideExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException e,
      WebRequest request) {
    log.error(e.getMessage());
    return badRequest(e, request);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<ServerSideExceptionResponse> handleValidationExceptions(BindException e, WebRequest request) {

    log.error(e.getMessage());
    return badRequest(e, request);
  }

}
