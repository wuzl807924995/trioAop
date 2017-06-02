package io.github.zh.cn.trio.aop.cache.face;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public interface CacheFace {
	/**
	 * 
	 * @param aopUtilContext
	 *            上下文
	 * @return 是否含有缓存信息
	 */
	boolean hasCache(AopUtilContext<CacheBeanConfig> aopUtilContext);

	/**
	 *
	 * @param aopUtilContext
	 *            上下文
	 * @return 读取缓存信息
	 */
	Object getCache(AopUtilContext<CacheBeanConfig> aopUtilContext);

	/**
	 * @param aopUtilContext
	 *            上下文
	 * 
	 * @return 写入缓存信息
	 */
	boolean setCache(AopUtilContext<CacheBeanConfig> aopUtilContext);

	/**
	 * @param aopUtilContext
	 *            上下文
	 * @return 删除缓存信息
	 * 
	 */
	boolean removeCache(AopUtilContext<CacheBeanConfig> aopUtilContext);
}
