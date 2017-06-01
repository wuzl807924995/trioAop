package io.github.zh.cn.trio.aop.cache.config;

import io.github.zh.cn.trio.aop.cache.model.CacheModel;
import io.github.zh.cn.trio.aop.croe.base.format.Format;
import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;

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
	 * 缓存建 模板字符
	 */
	private String keyModelString;

	private Format format;

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

	public String getKeyModelString() {
		return keyModelString;
	}

	public void setKeyModelString(String keyModelString) {
		this.keyModelString = keyModelString;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}
}
