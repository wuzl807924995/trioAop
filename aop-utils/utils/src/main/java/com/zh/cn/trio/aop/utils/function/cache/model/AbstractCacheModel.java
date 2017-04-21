package com.zh.cn.trio.aop.utils.function.cache.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.aspect.CacheConfig;

public abstract class AbstractCacheModel implements CacheModel, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void execBefore(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {

	}

	@Override
	public void execAfter(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {

	}

	protected void getCacheResult(AopUtilContext<CacheConfig> aopUtilContext) {
		CacheFace cacheFace = getApplicationContext().getBean(CacheFace.class,
				aopUtilContext.getAopUtilConfig().getCacheFace());
		boolean hasCache = cacheFace.hasCache(aopUtilContext);
		if (hasCache) {
			aopUtilContext.setResultObject(cacheFace.getCache(aopUtilContext));
		}
	}

}
