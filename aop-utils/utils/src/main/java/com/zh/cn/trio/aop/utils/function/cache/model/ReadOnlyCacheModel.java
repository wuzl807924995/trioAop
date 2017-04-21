package com.zh.cn.trio.aop.utils.function.cache.model;

import org.springframework.stereotype.Component;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.aspect.CacheConfig;

@Component(value = CacheModel.READ_ONLY)
public class ReadOnlyCacheModel extends AbstractCacheModel {

	@Override
	public void execBefore(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {
		getCacheResult(aopUtilContext);
	}

}
