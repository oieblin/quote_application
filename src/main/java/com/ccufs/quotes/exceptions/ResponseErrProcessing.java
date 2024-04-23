package com.ccufs.quotes.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * The type Response err processing.
 */
@ControllerAdvice
@Slf4j
public class ResponseErrProcessing extends ResponseEntityExceptionHandler {

  @Nullable
  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
          Exception ex,
          @Nullable Object body,
          HttpHeaders headers,
          HttpStatusCode statusCode,
          WebRequest request) {
    if (statusCode.equals(HttpStatus.NOT_FOUND)) {
      ErrorResponseModel errorResponse =
              new ErrorResponseModel(statusCode.value(),
                      "Resource Not Found Error: " + ex.getMessage());
      return new ResponseEntity<>(errorResponse, headers, statusCode);
    } else if (statusCode.equals(HttpStatus.BAD_REQUEST)) {
      ErrorResponseModel errorResponse =
              new ErrorResponseModel(
                       statusCode.value(),
                      "Bad Request Error: "
                              + ex.getMessage());
      return new ResponseEntity<>(errorResponse, headers, statusCode);
    } else if (statusCode.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
      ErrorResponseModel errorResponse =
              new ErrorResponseModel(

                      statusCode.value(), "Internal Server Error: "
                      + ex.getMessage());
      return new ResponseEntity<>(errorResponse, headers, statusCode);
    }
    return new ResponseEntity<>(body, headers, statusCode);
  }

  /**
   * Handle internal server error exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseModel> handleInternalServerErrorException(Exception ex) {
    ErrorResponseModel errorResponse =
            new ErrorResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal Server Error: " + ex.getMessage()
                    );
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }
}