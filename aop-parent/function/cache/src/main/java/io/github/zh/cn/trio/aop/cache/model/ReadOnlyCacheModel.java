package io.github.zh.cn.trio.aop.cache.model;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanContext;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class ReadOnlyCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_ONLY;
	}
	
	
	@Override
	public void execBefore(AopUtilContext<CacheBeanContext> aopUtilContext) {
		getCacheResult(aopUtilContext);
	}

}
