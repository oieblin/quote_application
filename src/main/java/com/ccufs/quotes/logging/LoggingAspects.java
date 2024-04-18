package com.ccufs.quotes.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * The type Logging aspects.
 */
@Component
@Aspect
@Slf4j

public class LoggingAspects {
  /**
   * Log controller methods object.
   *
   * @param joinPoint the join point
   * @return the object
   * @throws Throwable the throwable
   */
  @Around("PointCuts.allMethodsFromController()")
  public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();

    log.info("Entering controller method: {}.{}", className, methodName);

    try {
      Object result = joinPoint.proceed();

      log.info("Exiting controller method: {}.{}", className, methodName);
      return result;
    } catch (Exception e) {
      log.error("Exception in controller method: {}.{}", className, methodName, e);
      throw e;
    }
  }

  /**
   * Log service methods object.
   *
   * @param joinPoint the join point
   * @return the object
   * @throws Throwable the throwable
   */
  @Around("PointCuts.allMethodsFromService()")
  public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    String className = joinPoint.getTarget().getClass().getSimpleName();
    String methodName = joinPoint.getSignature().getName();

    log.info("Entering service method: {}.{}", className, methodName);

    try {
      Object result = joinPoint.proceed();
      log.info("Exiting service method: {}.{}", className, methodName);
      return result;
    } catch (Exception e) {
      log.error("Exception in service method: {}.{}", className, methodName, e);
      throw e;
    }
  }
}
