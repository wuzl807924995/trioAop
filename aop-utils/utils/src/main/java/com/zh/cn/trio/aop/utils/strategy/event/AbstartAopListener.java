package com.zh.cn.trio.aop.utils.strategy.event;

import org.springframework.context.ApplicationListener;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;

public abstract class AbstartAopListener<T extends AopUtilConfig> implements ApplicationListener<AopEvent<T>> {

	public void onEvent(AopEvent<T> event, boolean async) {
		if (async == event.getAopUtilContext().getAopUtilConfig().isAsync()) {
			onEvent(event);
		}
	}

	@Override
	public void onApplicationEvent(AopEvent<T> event) {
		onEvent(event, false);
	}

	public abstract void onEvent(AopEvent<T> event);

}
