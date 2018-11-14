package com.tadigital.aspects;


import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;


public class LoggerAfterReturningAspect implements AfterReturningAdvice{

	private static final Logger LOGGER = Logger.getLogger(LoggerAfterReturningAspect.class);
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println(arg1.getName());
		LOGGER.info(arg1.getName() + " " + Arrays.toString(arg2) + arg3.getClass().getName() + " returns " + arg0.toString());
	}
	

}
