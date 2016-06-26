package com.sumit.aop.logger.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import com.sumit.aop.logger.aspect.annotations.AfterReturnLoggerAnnotation;

import ch.qos.logback.classic.Logger;

//@Component
@Aspect
public class AfterReturnLoggingAspect {
	static Logger logger = (Logger) LoggerFactory.getLogger(AfterReturnLoggingAspect.class);

	// @AfterReturning("execution(* *(..))")
	//@AfterReturning("@annotation(afterReturnLogger)")
	 @AfterReturning(
			   pointcut = "execution(@annotation(afterReturnLogger))",
			   returning = "result"
			  )
	public void afterReturnAdvice(JoinPoint joinPoint, AfterReturnLoggerAnnotation afterReturnLogger, Object result) throws Throwable {
		logger.info("Target class : " + joinPoint.getTarget().getClass().getName());
		logger.info("Signature name : " + joinPoint.getSignature().getName());
		logger.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
		logger.info(" The Return Value is " + result);
	}

}