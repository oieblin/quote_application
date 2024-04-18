package com.ccufs.quotes.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * The type Response err processing.
 */
@Slf4j
@RestControllerAdvice
@Validated
public class ResponseErrProcessing {
  /**
   * Handle illegal argument exception response err.
   *
   * @return the response err
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MethodArgumentNotValidException.class,
    MissingServletRequestParameterException.class,
    MethodArgumentTypeMismatchException.class,
    MissingServletRequestPartException.class,
    TypeMismatchException.class, HttpMessageNotReadableException.class})
  public ResponseErr handleIllegalArgumentException() {
    log.error("ERROR 400");
    return new ResponseErr(400, "BAD_REQUEST: "
            + "The client should not repeat this request without modification.");
  }

  /**
   * Handle found exception response err.
   *
   * @return the response err
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(Exception.class)
  public ResponseErr handleFoundException() {
    log.error("ERROR 404");
    return new ResponseErr(404, "NOT_FOUND: "
            + "the server did not find the resource at this address.");
  }

  /**
   * Handle internal server error response err.
   *
   * @return the response err
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ConversionNotSupportedException.class,
    HttpMessageNotWritableException.class})
  public ResponseErr handleInternalServerError() {
    log.error("ERROR 500");
    return new ResponseErr(500,
            "INTERNAL_SERVER_ERROR: "
                    + "the server encountered an unexpected condition that prevented "
                    + "it from fulfilling the request.");
  }
}
