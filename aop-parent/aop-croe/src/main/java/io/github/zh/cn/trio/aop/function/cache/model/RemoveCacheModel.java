package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;

@Component
public class RemoveCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return REMOVE;
	}

	
	@Override
	public void execBefore(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		getCacheFace().removeCache(runTimeContext, cacheConfig);
	}
}
