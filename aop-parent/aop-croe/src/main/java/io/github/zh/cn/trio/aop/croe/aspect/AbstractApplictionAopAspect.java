package io.github.zh.cn.trio.aop.croe.aspect;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstractApplictionAopAspect extends AbstractAopAspect implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
