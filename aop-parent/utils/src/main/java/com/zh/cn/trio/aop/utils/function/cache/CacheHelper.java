package com.zh.cn.trio.aop.utils.function.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;

public abstract class CacheHelper {

	private static Logger logger = LoggerFactory.getLogger(CacheHelper.class);

	public static void cache(AopUtilContext<CacheBeanConfig> aopUtilContext, String targetTime) {
		CacheModel cacheModel = aopUtilContext.getAopUtilConfig().getCacheModel();
		if (CacheBeanConfig.TIME_BEFORE.equals(targetTime)) {
			cacheModel.execBefore(aopUtilContext);
		} else if (CacheBeanConfig.TIME_AFTER.equals(targetTime)) {
			cacheModel.execAfter(aopUtilContext);
		} else {
			logger.error("cache target time not :" + targetTime);
		}
	}
}
