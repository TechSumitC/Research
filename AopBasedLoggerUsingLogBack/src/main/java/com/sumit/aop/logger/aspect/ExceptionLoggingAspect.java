package com.sumit.aop.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sumit.aop.logger.aspect.annotations.ExceptionLoggerAnnotation;

import ch.qos.logback.classic.Logger;

/**
 * The Class TimeLoggingAspect.
 */
@Component
@Aspect
public class ExceptionLoggingAspect {
	static Logger logger = (Logger) LoggerFactory.getLogger(ExceptionLoggingAspect.class);

	// , ExceptionLoggerAnnotation exceptionLogger
	 @AfterThrowing(pointcut = "execution(* *(..)) && @annotation(exceptionLogger))", throwing = "exception")
	//@AfterThrowing(pointcut = "execution(@annotation(exceptionLogger))", throwing = "exception")

	public void throwAdvice(JoinPoint throwPoint, ExceptionLoggerAnnotation exceptionLogger, Exception exception) throws Throwable {
		logger.debug("Throw Advice Called in Debug");
		logger.debug("Exception in " + throwPoint.getTarget().getClass().getName() + " Method: " + throwPoint.getSignature().getName() + " Message " + exception.getMessage());
		logger.info("Exception in " + throwPoint.getTarget().getClass().getName() + " Method: " + throwPoint.getSignature().getName() + " Message " + exception.getMessage()
				+ "Stack Trace ------------ \n " + exception.getStackTrace());
		// logger.info("Exception Aspect Logger"+ exception.getStackTrace());

	}

}