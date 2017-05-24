package com.zh.cn.trio.aop.utils.function.cache.model;

import org.springframework.stereotype.Component;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

@Component(value = CacheModel.READ_ONLY)
public class ReadOnlyCacheModel extends AbstractCacheModel {

	@Override
	public void execBefore(AopUtilContext<CacheBeanConfig> aopUtilContext) throws Throwable {
		getCacheResult(aopUtilContext);
	}

}
