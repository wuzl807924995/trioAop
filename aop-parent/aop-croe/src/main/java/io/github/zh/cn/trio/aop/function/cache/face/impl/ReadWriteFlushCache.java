package io.github.zh.cn.trio.aop.function.cache.face.impl;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.AbstractCache;

public class ReadWriteFlushCache extends AbstractCache {

	@Override
	public String getSimpleName() {
		return READ_WRITE_FLUSH;
	}

	
	@Override
	public void execAfter(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		setCacheResult(runTimeContext, cacheConfig, true);
	}
}
