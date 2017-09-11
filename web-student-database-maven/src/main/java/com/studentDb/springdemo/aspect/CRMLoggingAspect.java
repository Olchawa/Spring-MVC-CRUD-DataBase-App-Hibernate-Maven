package com.studentDb.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.studentDb.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.studentDb.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.studentDb.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut(" forControllerPackage() || forServicePackage() || forDaoPackage() ")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display called method
		String theMethod = theJoinPoint.getSignature().toLongString();
		myLogger.info("===>>> in @Before: calling method " + theMethod);

		// get the args
		Object[] args = theJoinPoint.getArgs();

		// loop and display args
		for (Object tempArg : args) {
			myLogger.info("===>>> argument: " + tempArg);
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display called method
		String theMethod = theJoinPoint.getSignature().toLongString();
		myLogger.info("===>>> in @AfterReturning: from method " + theMethod);
		
		// display data returned
		myLogger.info("===>>> result: " + theResult);

	}

}
