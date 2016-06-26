package com.sumit.aop.logger.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sumit.aop.logger.aspect.annotations.BeforeLoggerAnnotation;

import ch.qos.logback.classic.Logger;

@Component
@Aspect
public class BeforeLoggingAspect {
	static Logger logger = (Logger) LoggerFactory.getLogger(BeforeLoggingAspect.class);

	// @Before("execution(* *(..))")
	@Before("@annotation(beforeLogger)")
	public void beforeAdvice(JoinPoint joinPoint, BeforeLoggerAnnotation beforeLogger) throws Throwable {
		logger.info("Target class : " + joinPoint.getTarget().getClass().getName());
		logger.info("Signature name : " + joinPoint.getSignature().getName());
		logger.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	}

}