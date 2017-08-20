package io.github.zh.cn.trio.aop.function.cache.face.impl;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.AbstractCache;

@Component
public class RemoveCache extends AbstractCache {

	@Override
	public String getModelName() {
		return REMOVE;
	}

	
	@Override
	public void execBefore(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		getCacheFace().removeCache(runTimeContext, cacheConfig);
	}
}
