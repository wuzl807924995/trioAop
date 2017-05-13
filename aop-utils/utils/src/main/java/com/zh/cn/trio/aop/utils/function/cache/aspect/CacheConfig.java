package com.zh.cn.trio.aop.utils.function.cache.aspect;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;

public class CacheConfig extends AopUtilConfig<CacheConfig> {

	public CacheConfig() {
		setAround(true);
	}

	private int cacheTime;

	private CacheModel cacheModel;

	private CacheFace cacheFace;

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}

	public CacheModel getCacheModel() {
		return cacheModel;
	}

	public void setCacheModel(CacheModel cacheModel) {
		this.cacheModel = cacheModel;
	}

	public CacheFace getCacheFace() {
		return cacheFace;
	}

	public void setCacheFace(CacheFace cacheFace) {
		this.cacheFace = cacheFace;
	}

}
