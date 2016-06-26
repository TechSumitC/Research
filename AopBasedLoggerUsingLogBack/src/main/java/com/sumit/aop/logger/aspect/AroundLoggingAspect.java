package com.sumit.aop.logger.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sumit.aop.logger.aspect.annotations.AroundLoggerAnnotation;

import ch.qos.logback.classic.Logger;

@Component
@Aspect
public class AroundLoggingAspect {
	static Logger logger = (Logger) LoggerFactory.getLogger(AroundLoggingAspect.class);

	// @Around("execution(* *(..))")
	@Around("@annotation(aroundLogger)")
	public void aroundAdvice(ProceedingJoinPoint joinPoint, AroundLoggerAnnotation aroundLogger) throws Throwable {

		logger.info("Target class : " + joinPoint.getTarget().getClass().getName());
		logger.info("Signature name : " + joinPoint.getSignature().getName());
		logger.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

}