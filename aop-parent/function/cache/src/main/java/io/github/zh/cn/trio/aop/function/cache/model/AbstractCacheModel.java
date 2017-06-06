package io.github.zh.cn.trio.aop.function.cache.model;

import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

public abstract class AbstractCacheModel implements CacheModel {

	/**
	 * 缓存实现接口
	 */
	private CacheFace cacheFace;

	public CacheFace getCacheFace() {
		return cacheFace;
	}

	public void setCacheFace(CacheFace cacheFace) {
		this.cacheFace = cacheFace;
	}

	@Override
	public void execBefore(CacheBeanContext cacheBeanContext) {

	}

	@Override
	public void execAfter(CacheBeanContext cacheBeanContext) {

	}

	/**
	 * 读缓存结果
	 * 
	 * @param aopUtilContext
	 *            上下文
	 */
	protected void getCacheResult(CacheBeanContext cacheBeanContext) {
		boolean hasCache = cacheFace.hasCache(cacheBeanContext);
		if (hasCache) {
			cacheBeanContext.setResultObject(cacheFace.getCache(cacheBeanContext));
		}
	}

}
