package com.zh.cn.trio.aop.utils.function.cache;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.aspect.CacheConfig;

public interface CacheFace {
	/**
	 * 是否含有缓存信息
	 * 
	 * @param cacheStrategyInfo
	 * @return
	 */
	boolean hasCache(AopUtilContext<CacheConfig> aopUtilContext);

	/**
	 * 读取缓存信息
	 * 
	 * @param cacheStrategyInfo
	 * @return
	 */
	Object getCache(AopUtilContext<CacheConfig> aopUtilContext);

	/**
	 * 写入缓存信息
	 * 
	 * @param cacheStrategyInfo
	 * @return
	 */
	boolean setCache(AopUtilContext<CacheConfig> aopUtilContext);

	/**
	 * 删除缓存信息
	 * 
	 * @param cacheStrategyInfo
	 */
	boolean removeCache(AopUtilContext<CacheConfig> aopUtilContext);
}
