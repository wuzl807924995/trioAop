package io.github.zh.cn.trio.aop.function.cache.model;

import io.github.zh.cn.trio.aop.function.cache.config.CacheBeanContext;

/**
 * 缓存读写模式的接口
 * 
 * @author wuzl
 *
 */
public interface CacheModel {

	/**
	 * 只读 如果有缓存则读缓存 没有缓存则执行目标方法 但是不缓存本次结果
	 */
	public static final String READ_ONLY = "READ_ONLY";

	/**
	 * 读写 如果有缓存则读缓存 没有缓存则执行目标方法 然后缓存结果（推荐）
	 */
	public static final String READ_WRITE = "READ_WRITE";

	/**
	 * 强制读写 不管有没有缓存 都执行目标方法 然后刷新缓存结果
	 */
	public static final String READ_WRITE_FLUSH = "READ_WRITE_FLUSH";

	/**
	 * 删除 如果有缓存则执行再删除
	 */
	public static final String REMOVE = "REMOVE";

	String getModelName();

	/**
	 *前置执行 
	 * @param cacheBeanContext 上下文
	 */
	void execBefore(CacheBeanContext cacheBeanContext);

	/**
	 * 后置执行
	 *  @param cacheBeanContext 上下文
	 */
	void execAfter(CacheBeanContext cacheBeanContext);
}
