package io.github.zh.cn.trio.aop.function.cache.aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.adapter.CacheAdapter;
import io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.exception.ModelNotFindException;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 缓存拦截器
 *@since 2.0
 */
@Aspect
public class TrioCacheAnnotationAspect extends AbstractAopAspect {

	private static final String[] targetTime = new String[] { CacheConfig.TIME_BEFORE, CacheConfig.TIME_AFTER };

	/**
	 * 缓存规则适配器
	 */
	private CacheAdapter cacheAdapter;

	/**
	 * 缓存时间
	 */
	private int cacheTime;

	/**
	 * 默认缓存的key模板
	 */
	private String keyModelString;
	
	/**
	 * 支持的缓存模式
	 */
	private Map<String, CacheFace> cacheModelMap;

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

	protected CacheFace getAnnotationConfigCacheModel(String cacheModel) {
		CacheFace model = cacheModelMap.get(cacheModel);
		if (model!=null) {
			return model;
		}
		Map<String, CacheFace> map = getApplicationContext().getBeansOfType(CacheFace.class);
		for (String beanName : map.keySet()) {
			model = getApplicationContext().getBean(beanName, CacheFace.class);
			if (model.getModelName().equals(cacheModel)) {
				cacheModelMap.put(cacheModel, model);
			}
		}
		if (model==null) {
			throw new ModelNotFindException(cacheModel + " is not find by cacheModel");
		}
		return model;
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
		cacheConfig.setCacheFace(getAnnotationConfigCacheModel(trioCache.cacheModel()));
		return cacheConfig;

	}
}
