package com.zh.cn.trio.aop.utils.function.cache.model;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

public class ReadWriteFlushCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_WRITE_FLUSH;
	}
	
	
	@Override
	public void execAfter(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		CacheFace cacheFace = aopUtilContext.getAopUtilConfig().getCacheFace();
		cacheFace.setCache(aopUtilContext);
	}
}
