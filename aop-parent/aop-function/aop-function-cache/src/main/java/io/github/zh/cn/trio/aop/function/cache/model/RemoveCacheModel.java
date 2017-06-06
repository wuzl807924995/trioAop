package io.github.zh.cn.trio.aop.function.cache.model;

import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;

public class RemoveCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return REMOVE;
	}

	@Override
	public void execBefore(CacheBeanContext cacheBeanContext) {
		getCacheFace().removeCache(cacheBeanContext);
	}
}
