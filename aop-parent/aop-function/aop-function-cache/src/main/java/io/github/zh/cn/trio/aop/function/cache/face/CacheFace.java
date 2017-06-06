package io.github.zh.cn.trio.aop.function.cache.face;

import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;

public interface CacheFace {
	/**
	 * 
	 * @param cacheBeanConfig
	 *            上下文
	 * @return 是否含有缓存信息
	 */
	boolean hasCache(CacheBeanContext cacheBeanConfig);

	/**
	 *
	 * @param cacheBeanConfig
	 *            上下文
	 * @return 读取缓存信息
	 */
	Object getCache(CacheBeanContext cacheBeanConfig);

	/**
	 * @param cacheBeanConfig
	 *            上下文
	 * 
	 * @return 写入缓存信息
	 */
	boolean setCache(CacheBeanContext cacheBeanConfig);

	/**
	 * @param cacheBeanConfig
	 *            上下文
	 * @return 删除缓存信息
	 * 
	 */
	boolean removeCache(CacheBeanContext cacheBeanConfig);
}
