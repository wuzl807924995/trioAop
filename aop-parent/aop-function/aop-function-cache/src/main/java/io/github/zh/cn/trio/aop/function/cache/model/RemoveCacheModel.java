package io.github.zh.cn.trio.aop.function.cache.model;

import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;

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
