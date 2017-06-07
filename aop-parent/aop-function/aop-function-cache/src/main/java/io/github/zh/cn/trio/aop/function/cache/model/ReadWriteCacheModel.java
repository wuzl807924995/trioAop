package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;

@Component
public class ReadWriteCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_WRITE;
	}

	@Override
	public void execBefore(CacheBeanContext cacheBeanContext) {
		getCacheResult(cacheBeanContext);
	}

	@Override
	public void execAfter(CacheBeanContext cacheBeanContext) {
		getCacheFace().setCache(cacheBeanContext);
	}
}
