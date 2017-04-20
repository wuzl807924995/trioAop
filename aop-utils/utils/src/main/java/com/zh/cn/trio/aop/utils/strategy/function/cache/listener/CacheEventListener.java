package com.zh.cn.trio.aop.utils.strategy.function.cache.listener;

import org.springframework.context.ApplicationListener;

import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;
import com.zh.cn.trio.aop.utils.strategy.function.cache.aspect.CacheConfig;

public class CacheEventListener implements ApplicationListener<AopEvent<CacheConfig>> {

	@Override
	public void onApplicationEvent(AopEvent<CacheConfig> event) {
		event.getTargetTime();
	}

}
