package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;
import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

public abstract class AbstractCacheModel implements CacheModel, AbsBeanModel {

	/**
	 * 缓存实现接口
	 */
	@Autowired
	private CacheFace cacheFace;

	public CacheFace getCacheFace() {
		return cacheFace;
	}

	public void setCacheFace(CacheFace cacheFace) {
		this.cacheFace = cacheFace;
	}

	@Override
	public void execBefore(CacheBeanContext cacheBeanContext) {

	}

	@Override
	public void execAfter(CacheBeanContext cacheBeanContext) {

	}

	@Override
	public void beforeAop(AbsContext context) {
		CacheBeanContext cacheBeanContext = (CacheBeanContext) context;
		execBefore(cacheBeanContext);
	}

	@Override
	public void afertAop(AbsContext context) {
		CacheBeanContext cacheBeanContext = (CacheBeanContext) context;
		execAfter(cacheBeanContext);
	}

	@Override
	public void errorAop(AbsContext context) {

	}

	public abstract String getModelName();

	/**
	 * 读缓存结果
	 * 
	 * @param cacheBeanContext
	 *            上下文
	 */
	protected void getCacheResult(CacheBeanContext cacheBeanContext) {
		boolean hasCache = cacheFace.hasCache(cacheBeanContext);
		if (hasCache) {
			cacheBeanContext.setResultObject(cacheFace.getCache(cacheBeanContext));
		}
	}
	
	protected void setCacheResult(CacheBeanContext cacheBeanContext,boolean flush){
		if (flush || !cacheFace.hasCache(cacheBeanContext)) {
			cacheFace.setCache(cacheBeanContext);
		}
	}

}
