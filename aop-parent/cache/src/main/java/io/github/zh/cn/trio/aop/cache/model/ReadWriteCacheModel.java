package io.github.zh.cn.trio.aop.cache.model;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;

public class ReadWriteCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_WRITE;
	}

	@Override
	public void execBefore(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		getCacheResult(aopUtilContext);
	}

	@Override
	public void execAfter(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		getCacheFace().setCache(aopUtilContext);
	}
}
