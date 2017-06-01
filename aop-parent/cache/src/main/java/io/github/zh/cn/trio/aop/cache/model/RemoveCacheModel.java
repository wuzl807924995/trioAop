package io.github.zh.cn.trio.aop.cache.model;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

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
