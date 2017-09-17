package io.github.zh.cn.trio.aop.function.cache.face.impl;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.AbstractCache;

public class ReadWriteCache extends AbstractCache {

	@Override
	public String getModelName() {
		return READ_WRITE;
	}

	
	@Override
	public void execBefore(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		getCacheResult(runTimeContext, cacheConfig);
	}
	
	@Override
	public void execAfter(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		setCacheResult(runTimeContext, cacheConfig, false);
	}
	
}
