package io.github.zh.cn.trio.aop.cache.model;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;

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
