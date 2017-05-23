package com.zh.cn.trio.aop.utils.strategy.event.cache.listener;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;
import com.zh.cn.trio.aop.utils.strategy.event.AbstartAopListener;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public class CacheEventListener extends AbstartAopListener<CacheBeanConfig> {

	@Override
	public void onEvent(AopEvent<CacheBeanConfig> event) {
		try {
			if (AopUtilConfig.TIME_BEFORE.equals(event.getTargetTime())
					|| AopUtilConfig.TIME_AFTER.equals(event.getTargetTime())) {
				CacheModel cacheModel = event.getAopUtilContext().getAopUtilConfig().getCacheModel();
				if (AopUtilConfig.TIME_BEFORE.equals(event.getTargetTime())) {
					cacheModel.execBefore(event.getAopUtilContext());
				} else {
					cacheModel.execAfter(event.getAopUtilContext());
				}
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
