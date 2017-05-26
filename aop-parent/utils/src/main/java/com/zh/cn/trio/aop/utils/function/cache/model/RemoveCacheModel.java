package com.zh.cn.trio.aop.utils.function.cache.model;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

public class RemoveCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return REMOVE;
	}

	@Override
	public void execBefore(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		getCacheFace().removeCache(aopUtilContext);
	}
}
