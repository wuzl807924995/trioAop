package io.github.zh.cn.trio.aop.function.cache.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.adapter.CacheAdapter;
import io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.model.CacheModel;

@Aspect
public class TrioCacheAnnotationAspect extends AbstractAopAspect {

	private static final String[] targetTime = new String[] { CacheConfig.TIME_BEFORE, CacheConfig.TIME_AFTER };

	private CacheAdapter cacheAdapter;

	private int cacheTime;

	private String keyModelString;
	
	private Map<String, CacheModel> cacheModelMap;

	public CacheAdapter getCacheAdapter() {
		return cacheAdapter;
	}

	public void setCacheAdapter(CacheAdapter cacheAdapter) {
		this.cacheAdapter = cacheAdapter;
	}

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}

	public String getKeyModelString() {
		return keyModelString;
	}

	public void setKeyModelString(String keyModelString) {
		this.keyModelString = keyModelString;
	}

	
	public TrioCacheAnnotationAspect() {
		cacheModelMap=new HashMap<>();
	}
	
	@Around("@annotation(io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	protected CacheModel getAnnotationConfigCacheModel(String cacheModel) {
		CacheModel model = cacheModelMap.get(cacheModel);
		if (model!=null) {
			return model;
		}
		Map<String, CacheModel> map = getApplicationContext().getBeansOfType(CacheModel.class);
		for (String beanName : map.keySet()) {
			model = getApplicationContext().getBean(beanName, CacheModel.class);
			if (model.getModelName().equals(cacheModel)) {
				cacheModelMap.put(cacheModel, model);
				return model;
			}
		}
		throw new RuntimeException(cacheModel + " is not find by cacheModel");
	}

	@Override
	public RunTimeConfig initConfig(RunTimeContext runTimeContext) {
		TrioCache trioCache = runTimeContext.getAnnotation(TrioCache.class);
		CacheConfig cacheConfig = new CacheConfig();
		cacheConfig.setTargetTimes(targetTime);
		cacheConfig.setRunTimeAdapter(cacheAdapter);
		cacheConfig
				.setKeyModelString("".equals(trioCache.keyModelString()) ? keyModelString : trioCache.keyModelString());
		cacheConfig.setCacheTime(trioCache.cacheTime() == 0 ? cacheTime : trioCache.cacheTime());
		cacheConfig.setCacheModel(getAnnotationConfigCacheModel(trioCache.cacheModel()));
		return cacheConfig;

	}
}
