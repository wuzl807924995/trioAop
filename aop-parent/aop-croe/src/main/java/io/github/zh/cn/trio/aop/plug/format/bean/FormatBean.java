package io.github.zh.cn.trio.aop.plug.format.bean;

import java.lang.reflect.Method;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.ApplicationContext;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

public class FormatBean {

	private RunTimeContext runTimeContext;
	
	private RunTimeConfig runTimeConfig;

	public RunTimeContext getRunTimeContext() {
		return runTimeContext;
	}

	public void setRunTimeContext(RunTimeContext runTimeContext) {
		this.runTimeContext = runTimeContext;
	}

	public RunTimeConfig getRunTimeConfig() {
		return runTimeConfig;
	}

	public void setRunTimeConfig(RunTimeConfig runTimeConfig) {
		this.runTimeConfig = runTimeConfig;
	}

	
	public FormatBean() {
		super();
	}

	
	
	public FormatBean(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig) {
		super();
		this.runTimeContext = runTimeContext;
		this.runTimeConfig = runTimeConfig;
	}

	public ApplicationContext getApplicationContext() {
		return runTimeContext.getApplicationContext();
	}

	public Object getTarget() {
		return runTimeContext.getTarget();
	}

	public long getAroundTimeStarat() {
		return runTimeContext.getAroundTimeStarat();
	}

	public long getAroundTimeEnd() {
		return runTimeContext.getAroundTimeEnd();
	}

	public Throwable getThrowable() {
		return runTimeContext.getThrowable();
	}

	public MethodInvocationProceedingJoinPoint getMethodInvocationProceedingJoinPoint() {
		return runTimeContext.getMethodInvocationProceedingJoinPoint();
	}

	public Object getResultObject() {
		return runTimeContext.getResultObject();
	}

	public Object[] getTargetArgs() {
		return runTimeContext.getTargetArgs();
	}

	public Method getTargetMethod() {
		return runTimeContext.getTargetMethod();
	}

	public Class<?>[] getTargetArgsClass() {
		return runTimeContext.getTargetArgsClass();
	}

	public Class<?> getReturnClass() {
		return runTimeContext.getReturnClass();
	}

	public boolean isSetResult() {
		return runTimeContext.isSetResult();
	}

	public String[] getTargetTimes() {
		return runTimeConfig.getTargetTimes();
	}

	public RunTimeAdapter getRunTimeAdapter() {
		return runTimeConfig.getRunTimeAdapter();
	}

	public boolean isAround() {
		return runTimeConfig.isAround();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((runTimeConfig == null) ? 0 : runTimeConfig.hashCode());
		result = prime * result + ((runTimeContext == null) ? 0 : runTimeContext.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormatBean other = (FormatBean) obj;
		if (runTimeConfig == null) {
			if (other.runTimeConfig != null)
				return false;
		} else if (!runTimeConfig.equals(other.runTimeConfig))
			return false;
		if (runTimeContext == null) {
			if (other.runTimeContext != null)
				return false;
		} else if (!runTimeContext.equals(other.runTimeContext))
			return false;
		return true;
	}
	
	
	
}
