package com.zh.cn.trio.aop.utils.function.cache.strategy;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheHelper;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class SimpleCacheStrategy implements AopStrategy<CacheBeanConfig> {

	@Override
	public void operAop(AopUtilContext<CacheBeanConfig> aopUtilContext, String targetTime) {
		CacheHelper.cache(aopUtilContext, targetTime);
	}

}
