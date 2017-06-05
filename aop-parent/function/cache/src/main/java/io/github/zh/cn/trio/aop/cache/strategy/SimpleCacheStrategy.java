package io.github.zh.cn.trio.aop.cache.strategy;

import io.github.zh.cn.trio.aop.cache.CacheHelper;
import io.github.zh.cn.trio.aop.cache.config.CacheBeanContext;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public class SimpleCacheStrategy implements AopStrategy<CacheBeanContext> {

	@Override
	public void operAop(AopUtilContext<CacheBeanContext> aopUtilContext, String targetTime) {
		CacheHelper.cache(aopUtilContext, targetTime);
	}

}
