package io.github.zh.cn.trio.aop.function.cache.adapter;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneModelAdapter extends CacheAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private CacheFace cacheFace;

	public CacheFace getCacheFace() {
		return cacheFace;
	}
	
	public void setCacheFace(CacheFace cacheFace) {
		this.cacheFace = cacheFace;
	}

	@Override
	public void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		if (runTimeConfig instanceof CacheConfig) {
			CacheConfig cacheConfig = (CacheConfig) runTimeConfig;
			switch (targetTime) {
			case CacheConfig.TIME_BEFORE:
				cacheFace.execBefore(runTimeContext, cacheConfig);
				break;
			case CacheConfig.TIME_AFTER:
				cacheFace.execAfter(runTimeContext, cacheConfig);
				break;
			default:
				logger.warn(targetTime + "is not in CacheConfig");
				break;
			}
		} else {
			logger.warn(runTimeConfig + "is not CacheConfig");
		}
	}
}
