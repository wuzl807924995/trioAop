package io.github.zh.cn.trio.aop.cache.model;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanContext;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class RemoveCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return REMOVE;
	}

	@Override
	public void execBefore(AopUtilContext<CacheBeanContext> aopUtilContext) {
		getCacheFace().removeCache(aopUtilContext);
	}
}
