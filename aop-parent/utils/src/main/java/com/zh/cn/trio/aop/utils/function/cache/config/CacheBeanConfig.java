package com.zh.cn.trio.aop.utils.function.cache.config;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;

/**
 * 
 * 缓存配置
 *
 */
public class CacheBeanConfig extends AopUtilConfig<CacheBeanConfig> {

	/**
	 * 缓存时间
	 */
	private int cacheTime;

	/**
	 * 缓存模式
	 */
	private CacheModel cacheModel;

	/**
	 * 缓存实现接口
	 */
	private CacheFace cacheFace;
	
	/**
	 * 缓存建 模板字符
	 */
	private String keyModelString;

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

	public String getKeyModelString() {
		return keyModelString;
	}

	public void setKeyModelString(String keyModelString) {
		this.keyModelString = keyModelString;
	}

}
