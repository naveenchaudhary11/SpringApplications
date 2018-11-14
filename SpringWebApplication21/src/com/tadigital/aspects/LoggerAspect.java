package com.tadigital.aspects;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;


public class LoggerAspect implements MethodInterceptor{

	private static final Logger LOGGER = Logger.getLogger(LoggerAspect.class);
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		LOGGER.info(mi.getMethod().getName() + " execution started");
		Object returnValue = mi.proceed();
		LOGGER.info(mi.getMethod().getName() + " execution finished with return value " + returnValue);
		
		return returnValue;
	}

	

}
