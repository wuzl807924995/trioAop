package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;
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
	public void execAfter(CacheBeanContext cacheBeanContext) {

	}

	@Override
	public void execBefore(CacheBeanContext cacheBeanContext) {

	}

	/**
	 * 读缓存结果
	 * 
	 * @param cacheBeanContext
	 *            上下文
	 */
	protected void getCacheResult(CacheBeanContext cacheBeanContext) {
		boolean hasCache = cacheFace.hasCache(cacheBeanContext);
		if (hasCache) {
			cacheBeanContext.setResultObject(cacheFace.getCache(cacheBeanContext));
		}
	}

	protected void setCacheResult(CacheBeanContext cacheBeanContext, boolean flush) {
		if (flush || !cacheFace.hasCache(cacheBeanContext)) {
			cacheFace.setCache(cacheBeanContext);
		}
	}

}
