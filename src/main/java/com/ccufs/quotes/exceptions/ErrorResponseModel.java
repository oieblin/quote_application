package com.ccufs.quotes.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * The type Response err.
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponseModel {
  private Integer errorCode;
  private String errorMessage;
}
