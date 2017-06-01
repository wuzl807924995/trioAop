package io.github.zh.cn.trio.aop.croe.base.format.utils;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;

public class FormatBean {

	private Object target;
	private Method targetMethod;
	private Object[] targetArgs;

	private ApplicationContext applicationContext;
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

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
