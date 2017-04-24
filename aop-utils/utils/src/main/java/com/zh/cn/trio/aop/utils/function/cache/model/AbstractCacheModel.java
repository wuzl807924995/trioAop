package com.zh.cn.trio.aop.utils.function.cache.model;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.aspect.CacheConfig;

public abstract class AbstractCacheModel implements CacheModel {


	@Override
	public void execBefore(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {

	}

	@Override
	public void execAfter(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {

	}

	protected void getCacheResult(AopUtilContext<CacheConfig> aopUtilContext) {
		CacheFace cacheFace =aopUtilContext.getAopUtilConfig().getCacheFace();
		boolean hasCache = cacheFace.hasCache(aopUtilContext);
		if (hasCache) {
			aopUtilContext.setResultObject(cacheFace.getCache(aopUtilContext));
		}
	}

}
