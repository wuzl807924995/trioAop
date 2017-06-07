package io.github.zh.cn.trio.aop.function.cache.strategy;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;
import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;

public class CacheStrategyModel implements AbsBeanModel {

	@Override
	public void beforeAop(AbsContext context) {
		CacheBeanContext cacheBeanContext = (CacheBeanContext) context;
		cacheBeanContext.getCacheModel().execBefore(cacheBeanContext);
	}

	@Override
	public void afertAop(AbsContext context) {
		CacheBeanContext cacheBeanContext = (CacheBeanContext) context;
		cacheBeanContext.getCacheModel().execAfter(cacheBeanContext);

	}

	@Override
	public void errorAop(AbsContext context) {

	}

}
