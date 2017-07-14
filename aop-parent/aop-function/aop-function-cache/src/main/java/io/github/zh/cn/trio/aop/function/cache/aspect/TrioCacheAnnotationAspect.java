package io.github.zh.cn.trio.aop.function.cache.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache;
import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;
import io.github.zh.cn.trio.aop.function.cache.model.CacheModel;

@Aspect
public class TrioCacheAnnotationAspect extends AbstractAopAspect<CacheBeanContext> {

	public static final String[] targetTime = new String[] { CacheBeanContext.TIME_BEFORE,
			CacheBeanContext.TIME_AFTER };

	@Autowired
	@Qualifier("readWriteCacheModel")
	private CacheModel defaultCacheModel;

	@Autowired
	@Qualifier("cacheStrategy")
	private AopStrategy defaultAopStrategy;

	private String defaultKeyModelString = "'method:'+getTargetMethod()+':args:'+getTargetArgs().toString()";

	public CacheModel getDefaultCacheModel() {
		return defaultCacheModel;
	}

	public void setDefaultCacheModel(CacheModel defaultCacheModel) {
		this.defaultCacheModel = defaultCacheModel;
	}

	public String getDefaultKeyModelString() {
		return defaultKeyModelString;
	}

	public void setDefaultKeyModelString(String defaultKeyModelString) {
		this.defaultKeyModelString = defaultKeyModelString;
	}

	public AopStrategy getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	protected CacheModel getAnnotationConfigCacheModel(String cacheModel) {
		Map<String, CacheModel> map = getApplicationContext().getBeansOfType(CacheModel.class);
		for (String beanName : map.keySet()) {
			CacheModel model = getApplicationContext().getBean(beanName, CacheModel.class);
			if (model.getModelName().equals(cacheModel)) {
				return model;
			}
		}
		return defaultCacheModel;
	}

	@Override
	public CacheBeanContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		CacheBeanContext cacheBeanContext = new CacheBeanContext();
		cacheBeanContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
		cacheBeanContext.setApplicationContext(getApplicationContext());

		TrioCache trioCache = cacheBeanContext.getTargetMethod().getAnnotation(TrioCache.class);

		AopStrategy aopStrategy = BeanUtils.getBean(getApplicationContext(), trioCache.aopStrategy(), AopStrategy.class,
				getDefaultAopStrategy());
		String formatString = StringUtils.isEmpty(trioCache.keyModelString()) ? defaultKeyModelString
				: trioCache.keyModelString();
		CacheModel abstractCacheModel = getAnnotationConfigCacheModel(trioCache.cacheModel());

		cacheBeanContext.setAopStrategy(aopStrategy);
		cacheBeanContext.setCacheTime(trioCache.cacheTime());
		cacheBeanContext.setTargetTimes(targetTime);
		cacheBeanContext.setKeyModelString(formatString);
		cacheBeanContext.setCacheModel(abstractCacheModel);

		return cacheBeanContext;
	}
}
