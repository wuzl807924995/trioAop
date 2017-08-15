package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;

@Component
public class ReadWriteCacheModel extends AbstractCacheModel {

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
