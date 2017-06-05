package io.github.zh.cn.trio.aop.cache.model;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanContext;
import io.github.zh.cn.trio.aop.cache.face.CacheFace;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

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
	public void execBefore(CacheBeanContext cacheBeanConfig) {

	}

	@Override
	public void execAfter(CacheBeanContext cacheBeanConfig) {

	}

	/**
	 * 读缓存结果
	 * 
	 * @param aopUtilContext
	 *            上下文
	 */
	protected void getCacheResult(CacheBeanContext cacheBeanConfig) {
		boolean hasCache = cacheFace.hasCache(cacheBeanConfig);
		if (hasCache) {
			cacheBeanConfig.setResultObject(cacheFace.getCache(cacheBeanConfig));
		}
	}

}
