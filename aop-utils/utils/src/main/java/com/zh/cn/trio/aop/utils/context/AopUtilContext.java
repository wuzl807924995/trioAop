package com.zh.cn.trio.aop.utils.context;

import java.lang.reflect.Method;

import com.zh.cn.trio.aop.utils.bean.AopUtilBean;
import com.zh.cn.trio.aop.utils.format.Format;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class AopUtilContext<T> {

	private AopUtilBean<T> aopUtilBean;
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

	private AopStrategy aopStrategy;

	private Format format;

	public AopUtilBean<T> getAopUtilBean() {
		return aopUtilBean;
	}

	public void setAopUtilBean(AopUtilBean<T> aopUtilBean) {
		this.aopUtilBean = aopUtilBean;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
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

	public AopStrategy getAopStrategy() {
		return aopStrategy;
	}

	public void setAopStrategy(AopStrategy aopStrategy) {
		this.aopStrategy = aopStrategy;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public void operAop(String targetTime) {
		boolean enable = this.getAopUtilBean().checkEnable(targetTime);
		if (enable) {
			this.getAopStrategy().operAop(this, targetTime);
		}
	}
}
