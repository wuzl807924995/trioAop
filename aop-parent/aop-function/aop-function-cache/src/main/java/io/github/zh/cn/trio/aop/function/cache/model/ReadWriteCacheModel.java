package io.github.zh.cn.trio.aop.function.cache.model;

import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;

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
