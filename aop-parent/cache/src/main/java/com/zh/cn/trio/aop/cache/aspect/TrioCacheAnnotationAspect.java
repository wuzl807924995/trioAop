package com.zh.cn.trio.aop.cache.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.cache.annotation.TrioCache;
import com.zh.cn.trio.aop.utils.aspect.AbstractAnnotationConfigAspect;
import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;
import com.zh.cn.trio.aop.utils.function.cache.model.CacheModel;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

@Aspect
public class TrioCacheAnnotationAspect extends AbstractAnnotationConfigAspect<CacheBeanConfig, TrioCache> {


	private CacheModel defaultCacheModel;

	private String defaultKeyModelString="'method:'+getTargetMethod()+':args:'+getTargetArgs()";


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

	@Around("@annotation(com.zh.cn.trio.aop.cache.annotation.TrioCache)")
	@Override
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxyAnnotation(proceedingJoinPoint);
	}

	@Override
	public Class<TrioCache> getAnnotationClass() {
		return TrioCache.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CacheBeanConfig crateConfig(TrioCache trioCache) {
		CacheBeanConfig cacheBeanConfig = new CacheBeanConfig();

		AopStrategy<CacheBeanConfig> aopStrategy = getBean(trioCache.aopStrategy(), AopStrategy.class,
				getDefaultAopStrategy());
		CacheModel cacheModel = getAnnotationConfigCacheModel(trioCache.cacheModel());
		Format format = getBean(trioCache.format(), Format.class, getDefaultFormat());
		String modelString = trioCache.keyModelString();
		if (StringUtils.isEmpty(modelString)) {
			modelString = defaultKeyModelString;
		}

		cacheBeanConfig.setAopStrategy(aopStrategy);
		cacheBeanConfig.setCacheModel(cacheModel);
		cacheBeanConfig.setCacheTime(trioCache.cacheTime());
		cacheBeanConfig.setFormat(format);
		cacheBeanConfig.setKeyModelString(modelString);
		cacheBeanConfig.setTargetTimes(trioCache.targetTime());

		return cacheBeanConfig;
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

}
