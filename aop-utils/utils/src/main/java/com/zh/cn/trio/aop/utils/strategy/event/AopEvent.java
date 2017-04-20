package com.zh.cn.trio.aop.utils.strategy.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public class AopEvent<T> extends ApplicationContextEvent {

	

	private static final long serialVersionUID = -2277036805614513916L;

	private AopUtilContext<T> aopUtilContext;
	
	private String targetTime;
	
	public AopUtilContext<T> getAopUtilContext() {
		return aopUtilContext;
	}
	
	public void setAopUtilContext(AopUtilContext<T> aopUtilContext) {
		this.aopUtilContext = aopUtilContext;
	}
	
	public String getTargetTime() {
		return targetTime;
	}
	
	public void setTargetTime(String targetTime) {
		this.targetTime = targetTime;
	}
	
	public AopEvent(ApplicationContext source) {
		super(source);
	}
	
	public AopEvent(ApplicationContext source,AopUtilContext<T> aopUtilContext,String targetTime) {
		super(source);
		this.aopUtilContext=aopUtilContext;
		this.targetTime=targetTime;
	}
	

}
