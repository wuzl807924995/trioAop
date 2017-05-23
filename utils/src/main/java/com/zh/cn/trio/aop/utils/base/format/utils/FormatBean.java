package com.zh.cn.trio.aop.utils.base.format.utils;

import java.lang.reflect.Method;

public class FormatBean {

	private Object target;
	private Method targetMethod;
	private Object[] targetArgs;
	
	private Object[] extension;

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public Object[] getTargetArgs() {
		return targetArgs;
	}

	public void setTargetArgs(Object[] targetArgs) {
		this.targetArgs = targetArgs;
	}

	public Object[] getExtension() {
		return extension;
	}

	public void setExtension(Object[] extension) {
		this.extension = extension;
	}

}
