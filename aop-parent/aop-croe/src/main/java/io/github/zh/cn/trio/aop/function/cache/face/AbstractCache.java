package io.github.zh.cn.trio.aop.function.cache.face;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.decorate.CacheOperation;

public abstract class AbstractCache implements CacheFace {

	/**
	 * 缓存实现接口
	 */
	@Autowired
	private CacheOperation cacheOperation;

	public CacheOperation getCacheFace() {
		return cacheOperation;
	}

	public void setCacheFace(CacheOperation cacheOperation) {
		this.cacheOperation = cacheOperation;
	}

	@Override
	public void execAfter(RunTimeContext runTimeContext,CacheConfig cacheConfig) {

	}

	@Override
	public void execBefore(RunTimeContext runTimeContext,CacheConfig cacheConfig) {

	}

	/**
	 * 读缓存结果
	 * @param runTimeContext 上下文
	 * @param cacheConfig 配置
	 */
	protected void getCacheResult(RunTimeContext runTimeContext,CacheConfig cacheConfig) {
		boolean hasCache = cacheOperation.hasCache(runTimeContext,cacheConfig);
		if (hasCache) {
			runTimeContext.setResultObject(cacheOperation.getCache(runTimeContext,cacheConfig));
		}
	}
	/**
	 * 写入缓存结果
	 * @param runTimeContext 上下文
	 * @param cacheConfig 配置
	 */
	protected void setCacheResult(RunTimeContext runTimeContext,CacheConfig cacheConfig, boolean flush) {
		if (flush || !cacheOperation.hasCache(runTimeContext,cacheConfig)) {
			cacheOperation.setCache(runTimeContext,cacheConfig);
		}
	}

}
