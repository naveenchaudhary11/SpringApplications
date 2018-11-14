package com.tadigital.aspects;


import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;


public class LoggerBeforeAspect implements MethodBeforeAdvice{

	private static final Logger LOGGER = Logger.getLogger(LoggerBeforeAspect.class);
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println(arg0.getName());
		LOGGER.info(arg0.getName() + " " + Arrays.toString(arg1) +" "+ arg2.toString());
	}

}
