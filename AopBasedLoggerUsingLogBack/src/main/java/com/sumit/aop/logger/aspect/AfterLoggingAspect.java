package com.sumit.aop.logger.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sumit.aop.logger.aspect.annotations.AfterLoggerAnnotation;

import ch.qos.logback.classic.Logger;

@Component
@Aspect
public class AfterLoggingAspect {
	static Logger logger = (Logger) LoggerFactory.getLogger(AfterLoggingAspect.class);

	// @After("execution(* *(..))")
	@After("@annotation(afterLogger)")
	public void afterAdvice(JoinPoint joinPoint, AfterLoggerAnnotation afterLogger) throws Throwable {
		logger.info("Target class : " + joinPoint.getTarget().getClass().getName());
		logger.info("Signature name : " + joinPoint.getSignature().getName());
		logger.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

}