package com.zh.cn.trio.aop.utils.function.cache.model;

import org.springframework.stereotype.Component;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.aspect.CacheConfig;

@Component(value = CacheModel.READ_WRITE_FLUSH)
public class ReadWriteFlushCacheModel extends AbstractCacheModel {

	@Override
	public void execBefore(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {
		getCacheResult(aopUtilContext);
	}

	@Override
	public void execAfter(AopUtilContext<CacheConfig> aopUtilContext) throws Throwable {
		CacheFace cacheFace = getApplicationContext().getBean(CacheFace.class,
				aopUtilContext.getAopUtilConfig().getCacheFace());
		cacheFace.setCache(aopUtilContext);
	}
}
