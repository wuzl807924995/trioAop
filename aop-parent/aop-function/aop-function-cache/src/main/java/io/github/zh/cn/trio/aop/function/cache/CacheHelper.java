package io.github.zh.cn.trio.aop.function.cache;
//package io.github.zh.cn.trio.aop.cache;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import io.github.zh.cn.trio.aop.cache.config.CacheBeanContext;
//import io.github.zh.cn.trio.aop.cache.model.CacheModel;
//import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
//
//public abstract class CacheHelper {
//
//	private static Logger logger = LoggerFactory.getLogger(CacheHelper.class);
//
//	public static void cache(AopUtilContext<CacheBeanContext> aopUtilContext, String targetTime) {
//		CacheModel cacheModel = aopUtilContext.getAopUtilConfig().getCacheModel();
//		if (CacheBeanContext.TIME_BEFORE.equals(targetTime)) {
//			cacheModel.execBefore(aopUtilContext);
//		} else if (CacheBeanContext.TIME_AFTER.equals(targetTime)) {
//			cacheModel.execAfter(aopUtilContext);
//		} else {
//			logger.error("cache target time not :" + targetTime);
//		}
//	}
//}
