package com.zh.cn.trio.aop.utils.strategy.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class EventAopStrategy implements AopStrategy,ApplicationContextAware{

	private ApplicationContext applicationContext;
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Override
	public <T> void operAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		ApplicationEvent event=new AopEvent<T>(this.applicationContext, aopUtilContext, targetTime);
		this.applicationContext.publishEvent(event);
	}

}
