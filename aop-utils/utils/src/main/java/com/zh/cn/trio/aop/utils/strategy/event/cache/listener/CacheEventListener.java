package com.zh.cn.trio.aop.utils.strategy.event.cache.listener;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.cache.aspect.CacheConfig;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;
import com.zh.cn.trio.aop.utils.strategy.event.AbstartAopListener;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public class CacheEventListener extends AbstartAopListener<CacheConfig> {

	@Override
	public void onEvent(AopEvent<CacheConfig> event) {
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
