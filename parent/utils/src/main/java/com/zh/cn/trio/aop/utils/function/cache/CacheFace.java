package com.zh.cn.trio.aop.utils.function.cache;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

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
