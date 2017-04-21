package com.zh.cn.trio.aop.utils.function.cache.aspect;

import com.zh.cn.trio.aop.utils.aspect.AbstractAopAspect;
import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;

public class CacheXmlAspect extends AbstractAopAspect<CacheConfig> {

	private CacheConfig cacheConfig;

	public CacheConfig getCacheConfig() {
		return cacheConfig;
	}

	public void setCacheConfig(CacheConfig cacheConfig) {
		this.cacheConfig = cacheConfig;
	}

	@Override
	public CacheConfig createBean(AopUtilContext<CacheConfig> aopUtilContext) {
		return cacheConfig;
	}

}
