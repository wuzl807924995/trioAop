package io.github.zh.cn.trio.aop.function.cache.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache;
import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;
import io.github.zh.cn.trio.aop.function.cache.model.AbstractCacheModel;
import io.github.zh.cn.trio.aop.plug.format.Format;

@Aspect
public class TrioCacheAnnotationAspect extends AbstractAopAspect {

	public static final String[] targetTime = new String[] { CacheBeanContext.TIME_BEFORE,
			CacheBeanContext.TIME_AFTER };

	@Autowired
	@Qualifier("readWriteCacheModel")
	private AbstractCacheModel defaultCacheModel;

	@Autowired
	private Format defaultFormat;

	@Autowired
	private AopStrategy defaultAopStrategy;

	private String defaultKeyModelString = "'method:'+getTargetMethod()+':args:'+getTargetArgs().toString()";

	public AbstractCacheModel getDefaultCacheModel() {
		return defaultCacheModel;
	}

	public void setDefaultCacheModel(AbstractCacheModel defaultCacheModel) {
		this.defaultCacheModel = defaultCacheModel;
	}

	public String getDefaultKeyModelString() {
		return defaultKeyModelString;
	}

	public void setDefaultKeyModelString(String defaultKeyModelString) {
		this.defaultKeyModelString = defaultKeyModelString;
	}

	public Format getDefaultFormat() {
		return defaultFormat;
	}

	public void setDefaultFormat(Format defaultFormat) {
		this.defaultFormat = defaultFormat;
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

	protected AbstractCacheModel getAnnotationConfigCacheModel(String cacheModel) {
		Map<String, AbstractCacheModel> map = getApplicationContext().getBeansOfType(AbstractCacheModel.class);
		for (String beanName : map.keySet()) {
			AbstractCacheModel model = getApplicationContext().getBean( beanName,AbstractCacheModel.class);
			if (model.getModelName().equals(cacheModel)) {
				return model;
			}
		}
		return defaultCacheModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CacheBeanContext initContext(AopUtilContext aopUtilContext) {
		CacheBeanContext cacheBeanContext = new CacheBeanContext();
		cacheBeanContext = CacheBeanContext.copyContext(aopUtilContext, cacheBeanContext);

		TrioCache trioCache = cacheBeanContext.getTargetMethod().getAnnotation(TrioCache.class);

		AopStrategy aopStrategy = BeanUtils.getBean(getApplicationContext(), trioCache.aopStrategy(), AopStrategy.class,
				getDefaultAopStrategy());
		Format format = BeanUtils.getBean(getApplicationContext(), trioCache.format(), Format.class, defaultFormat);
		AbstractCacheModel cacheModel = getAnnotationConfigCacheModel(trioCache.cacheModel());
		String formatString = StringUtils.isEmpty(trioCache.keyModelString()) ? defaultKeyModelString
				: trioCache.keyModelString();

		cacheBeanContext.setAopStrategy(aopStrategy);
		cacheBeanContext.setFormat(format);
		cacheBeanContext.setCacheModel(cacheModel);
		cacheBeanContext.setCacheTime(trioCache.cacheTime());
		cacheBeanContext.setTargetTimes(targetTime);
		cacheBeanContext.setKeyModelString(formatString);

		return cacheBeanContext;
	}
}
