package com.zh.cn.trio.aop.utils.function.cache.config;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;

public class CacheBeanConfig extends AopUtilConfig<CacheBeanConfig> {

	private int cacheTime;

	private CacheModel cacheModel;

	private CacheFace cacheFace;
	
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
