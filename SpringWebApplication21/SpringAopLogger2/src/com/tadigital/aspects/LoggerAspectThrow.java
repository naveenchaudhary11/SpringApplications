package com.tadigital.aspects;


import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.DivideOperator;
import org.springframework.aop.ThrowsAdvice;


public class LoggerAspectThrow implements ThrowsAdvice{

	private static final Logger LOGGER = Logger.getLogger(LoggerAspectThrow.class);
	
	public void afterThrowing(Method method, Object[] args, Object target, NullPointerException nfex) {
		System.out.println("throws advice");
		
		LOGGER.info(method.getName() + " with arguments " + Arrays.toString(args) + " from class " + target.getClass().getName() + " has thrown " + nfex);
	}
}
