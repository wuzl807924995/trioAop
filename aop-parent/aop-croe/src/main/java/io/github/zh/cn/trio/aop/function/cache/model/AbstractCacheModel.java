package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

public abstract class AbstractCacheModel implements CacheModel {

	/**
	 * 缓存实现接口
	 */
	@Autowired
	private CacheFace cacheFace;

	public CacheFace getCacheFace() {
		return cacheFace;
	}

	public void setCacheFace(CacheFace cacheFace) {
		this.cacheFace = cacheFace;
	}

	@Override
	public void execAfter(RunTimeContext runTimeContext,CacheConfig cacheConfig) {

	}

	@Override
	public void execBefore(RunTimeContext runTimeContext,CacheConfig cacheConfig) {

	}

	/**
	 * 读缓存结果
	 * 
	 * @param cacheBeanContext
	 *            上下文
	 */
	protected void getCacheResult(RunTimeContext runTimeContext,CacheConfig cacheConfig) {
		boolean hasCache = cacheFace.hasCache(runTimeContext,cacheConfig);
		if (hasCache) {
			runTimeContext.setResultObject(cacheFace.getCache(runTimeContext,cacheConfig));
		}
	}

	protected void setCacheResult(RunTimeContext runTimeContext,CacheConfig cacheConfig, boolean flush) {
		if (flush || !cacheFace.hasCache(runTimeContext,cacheConfig)) {
			cacheFace.setCache(runTimeContext,cacheConfig);
		}
	}

}
