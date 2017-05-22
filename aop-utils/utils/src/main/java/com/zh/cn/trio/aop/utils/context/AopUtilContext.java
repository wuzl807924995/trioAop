package com.zh.cn.trio.aop.utils.context;

import java.lang.reflect.Method;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class AopUtilContext<T extends AopUtilConfig<T>> {

	private T aopUtilConfig;

	private long aroundTimeStarat;

	private long aroundTimeEnd;

	private Throwable throwable;

	private boolean setResult;

	private Class<?>[] targetArgsClass;

	private MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint;

	private Object target;
	/**
	 * 拦截方法
	 */
	private Method targetMethod;
	/**
	 * 拦截方法入参
	 */
	private Object[] targetArgs;
	/**
	 * 返回值
	 */
	private Object resultObject;

	public T getAopUtilConfig() {
		return aopUtilConfig;
	}

	public void setAopUtilConfig(T aopUtilConfig) {
		this.aopUtilConfig = aopUtilConfig;
	}

	public Object getTarget() {
		if (target == null) {
			target = methodInvocationProceedingJoinPoint.getTarget();
		}
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public long getAroundTimeStarat() {
		return aroundTimeStarat;
	}

	public void setAroundTimeStarat(long aroundTimeStarat) {
		this.aroundTimeStarat = aroundTimeStarat;
	}

	public long getAroundTimeEnd() {
		return aroundTimeEnd;
	}

	public void setAroundTimeEnd(long aroundTimeEnd) {
		this.aroundTimeEnd = aroundTimeEnd;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public MethodInvocationProceedingJoinPoint getMethodInvocationProceedingJoinPoint() {
		return methodInvocationProceedingJoinPoint;
	}

	public void setMethodInvocationProceedingJoinPoint(
			MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		this.methodInvocationProceedingJoinPoint = methodInvocationProceedingJoinPoint;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.setResult = true;
		this.resultObject = resultObject;
	}

	public Object[] getTargetArgs() {
		if (targetArgs == null) {
			targetArgs = methodInvocationProceedingJoinPoint.getArgs();
		}
		return targetArgs;
	}

	public void setTargetArgs(Object[] targetArgs) {
		this.targetArgs = targetArgs;
	}

	public Method getTargetMethod() {
		if (targetMethod == null) {
			// targetMethod=
			MethodSignature signature = (MethodSignature) methodInvocationProceedingJoinPoint.getSignature();
			targetMethod = signature.getMethod();
		}
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public Class<?>[] getTargetArgsClass() {
		if (targetArgsClass==null) {
			targetArgsClass=getTargetMethod().getParameterTypes();
		}
		return targetArgsClass;
	}

	public void setTargetArgsClass(Class<?>[] targetArgsClass) {
		this.targetArgsClass = targetArgsClass;
	}

	public boolean isSetResult() {
		return setResult;
	}

	public void operAop(String targetTime) {
		boolean enable = this.aopUtilConfig.checkEnable(targetTime);
		if (enable) {
			this.getAopUtilConfig().getAopStrategy().operAop(this, targetTime);
		}
	}
}
