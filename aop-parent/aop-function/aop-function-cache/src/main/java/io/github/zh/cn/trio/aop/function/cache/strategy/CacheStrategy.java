package io.github.zh.cn.trio.aop.function.cache.strategy;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AbstractAopStrategy;
import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;

public class CacheStrategy extends AbstractAopStrategy{

	
	@Override
	public void beforeAop(AopUtilContext aopUtilContext) {
		CacheBeanContext cacheBeanContext=(CacheBeanContext) aopUtilContext;
		cacheBeanContext.getCacheModel().execBefore(cacheBeanContext);
	}
	
	@Override
	public void afertAop(AopUtilContext aopUtilContext) {
		CacheBeanContext cacheBeanContext=(CacheBeanContext) aopUtilContext;
		cacheBeanContext.getCacheModel().execAfter(cacheBeanContext);
	}
	
	
}
