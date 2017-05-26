package com.zh.cn.trio.aop.utils.function.cache.model;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

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
