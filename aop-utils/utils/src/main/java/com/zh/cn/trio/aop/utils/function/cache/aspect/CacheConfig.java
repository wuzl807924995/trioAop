package com.zh.cn.trio.aop.utils.function.cache.aspect;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;

public class CacheConfig extends AopUtilConfig {

	/**
	 * 缓存时间 根据不同的策略可以设置自己的默认时间
	 */
	private int cacheTime;

	private String cacheModel;

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}

	public String getCacheModel() {
		return cacheModel;
	}

	public void setCacheModel(String cacheModel) {
		this.cacheModel = cacheModel;
	}

	public CacheConfig() {
		setEnableAround(true);
	}
}
