package com.ccufs.quotes.logging;

import org.aspectj.lang.annotation.Pointcut;

/**
 * The type Point cuts.
 */
public class PointCuts {
  /**
   * All methods from controller.
   */
  @Pointcut(value = "execution(* com.ccufs.quotes.controller.*.*(..)) ")
  public void allMethodsFromController() {}

  /**
   * All methods.
   */
  @Pointcut(value = "execution(* com.ccufs.quotes.service.*.*(..)) ")
  public void allMethodsFromService() {}
}
