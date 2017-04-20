package com.zh.cn.trio.aop.utils.strategy.function.cache.aspect;

public class CacheConfig {

	/**
	 * 缓存时间 根据不同的策略可以设置自己的默认时间
	 */
	private int cacheTime;

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}
}
