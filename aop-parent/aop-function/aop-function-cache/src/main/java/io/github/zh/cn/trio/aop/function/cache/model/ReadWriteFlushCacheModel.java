package io.github.zh.cn.trio.aop.function.cache.model;

import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;

public class ReadWriteFlushCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_WRITE_FLUSH;
	}
	
	
	@Override
	public void execAfter(CacheBeanContext cacheBeanContext) {
		getCacheFace().setCache(cacheBeanContext);
	}
}
