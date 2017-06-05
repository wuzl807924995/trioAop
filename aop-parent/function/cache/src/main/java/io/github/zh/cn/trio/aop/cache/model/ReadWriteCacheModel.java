package io.github.zh.cn.trio.aop.cache.model;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanContext;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class ReadWriteCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_WRITE;
	}

	@Override
	public void execBefore(AopUtilContext<CacheBeanContext> aopUtilContext) {
		getCacheResult(aopUtilContext);
	}

	@Override
	public void execAfter(AopUtilContext<CacheBeanContext> aopUtilContext) {
		getCacheFace().setCache(aopUtilContext);
	}
}
