package io.github.zh.cn.trio.aop.function.cache.context;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

public class CacheConfig extends RunTimeConfig{
	/**
	 * @return 缓存时间
	 */
	private int cacheTime;

	/**
	 * @return 缓存模式
	 */
	private CacheFace cacheFace;

	/**
	 * @return 缓存建 模板字符
	 */
	private String keyModelString;

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}

	public CacheFace getCacheFace() {
		return cacheFace;
	}
	
	public void setCacheFace(CacheFace cacheFace) {
		this.cacheFace = cacheFace;
	}
	
	public String getKeyModelString() {
		return keyModelString;
	}

	public void setKeyModelString(String keyModelString) {
		this.keyModelString = keyModelString;
	}
}
