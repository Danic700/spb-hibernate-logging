package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AspectLogger {

	private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";

	@Around("execution(* com.example.demo.service..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		// Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		// Log method execution time
		String eventId = MDC.get(CORRELATION_ID_LOG_VAR_NAME);
		log.info("Execution time of " + className + "." + methodName + " " + ":: " + stopWatch.getTotalTimeMillis()
				+ " ms " + eventId);

		System.out.println(eventId);
		return result;
	}
}
