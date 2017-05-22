package com.zh.cn.trio.aop.utils.function.cache.model;

import org.springframework.stereotype.Component;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

@Component(value = CacheModel.READ_WRITE)
public class ReadWriteCacheModel extends AbstractCacheModel {

	@Override
	public void execBefore(AopUtilContext<CacheBeanConfig> aopUtilContext) throws Throwable {
		getCacheResult(aopUtilContext);
	}

	@Override
	public void execAfter(AopUtilContext<CacheBeanConfig> aopUtilContext) throws Throwable {
		CacheFace cacheFace =aopUtilContext.getAopUtilConfig().getCacheFace();
		cacheFace.setCache(aopUtilContext);
	}
}
