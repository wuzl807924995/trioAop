package io.github.zh.cn.trio.aop.cache.strategy;

import io.github.zh.cn.trio.aop.cache.CacheHelper;
import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public class SimpleCacheStrategy implements AopStrategy<CacheBeanConfig> {

	@Override
	public void operAop(AopUtilContext<CacheBeanConfig> aopUtilContext, String targetTime) {
		CacheHelper.cache(aopUtilContext, targetTime);
	}

}
