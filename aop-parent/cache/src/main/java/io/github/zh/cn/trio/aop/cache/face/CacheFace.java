package io.github.zh.cn.trio.aop.cache.face;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public interface CacheFace {
	/**
	 * 是否含有缓存信息
	 * 
	 * @param cacheStrategyInfo
	 * @return
	 */
	boolean hasCache(AopUtilContext<CacheBeanConfig> aopUtilContext);

	/**
	 * 读取缓存信息
	 * 
	 * @param cacheStrategyInfo
	 * @return
	 */
	Object getCache(AopUtilContext<CacheBeanConfig> aopUtilContext);

	/**
	 * 写入缓存信息
	 * 
	 * @param cacheStrategyInfo
	 * @return
	 */
	boolean setCache(AopUtilContext<CacheBeanConfig> aopUtilContext);

	/**
	 * 删除缓存信息
	 * 
	 * @param cacheStrategyInfo
	 */
	boolean removeCache(AopUtilContext<CacheBeanConfig> aopUtilContext);
}
