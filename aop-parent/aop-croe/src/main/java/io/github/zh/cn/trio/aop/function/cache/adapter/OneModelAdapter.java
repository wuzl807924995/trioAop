package io.github.zh.cn.trio.aop.function.cache.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.model.CacheModel;

public class OneModelAdapter extends CacheAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private CacheModel cacheModel;

	public CacheModel getCacheModel() {
		return cacheModel;
	}

	public void setCacheModel(CacheModel cacheModel) {
		this.cacheModel = cacheModel;
	}

	@Override
	public void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		if (runTimeConfig instanceof CacheConfig) {
			CacheConfig cacheConfig = (CacheConfig) runTimeConfig;
			switch (targetTime) {
			case CacheConfig.TIME_BEFORE:
				cacheModel.execBefore(runTimeContext, cacheConfig);
				break;
			case CacheConfig.TIME_AFTER:
				cacheModel.execAfter(runTimeContext, cacheConfig);
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
