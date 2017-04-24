package com.zh.cn.trio.aop.utils.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopUtilContext<T extends AopUtilConfig> {

	private T aopUtilConfig;

	private ProceedingJoinPoint proceedingJoinPoint;
	/**
	 * 返回值
	 */
	private Object resultObject;
	/**
	 * 拦截方法入参
	 */
	private Object[] targetArgs;
	/**
	 * 拦截方法
	 */
	private Method targetMethod;

	private long aroundTimeStarat;

	private long aroundTimeEnd;

	private Throwable throwable;

	public T getAopUtilConfig() {
		return aopUtilConfig;
	}

	public void setAopUtilConfig(T aopUtilConfig) {
		this.aopUtilConfig = aopUtilConfig;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public Object[] getTargetArgs() {
		return targetArgs;
	}

	public void setTargetArgs(Object[] targetArgs) {
		this.targetArgs = targetArgs;
	}

	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
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

	public ProceedingJoinPoint getProceedingJoinPoint() {
		return proceedingJoinPoint;
	}

	public void setProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
		this.proceedingJoinPoint = proceedingJoinPoint;
	}

	public void operAop(String targetTime) {
		boolean enable = this.aopUtilConfig.checkEnable(targetTime);
		if (enable) {
			this.getAopUtilConfig().getAopStrategy().operAop(this, targetTime);
		}
	}
}
