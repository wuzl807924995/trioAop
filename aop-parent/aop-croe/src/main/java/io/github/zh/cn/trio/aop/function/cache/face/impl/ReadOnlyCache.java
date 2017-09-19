package io.github.zh.cn.trio.aop.function.cache.face.impl;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.AbstractCache;

public class ReadOnlyCache extends AbstractCache {

	@Override
	public String getSimpleName() {
		return READ_ONLY;
	}


	@Override
	public void execBefore(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		getCacheResult(runTimeContext, cacheConfig);
	}
}
