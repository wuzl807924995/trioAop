package com.zh.cn.trio.aop.logger.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.zh.cn.trio.aop.logger.annotation.TrioLogger;
import com.zh.cn.trio.aop.utils.aspect.AbstractAnnotationConfigAspect;
import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAnnotationConfigAspect<LoggerBeanConfig,TrioLogger> {



	@Around("@annotation(com.zh.cn.trio.aop.logger.annotation.TrioLogger)")
	@Override
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxyAnnotation(proceedingJoinPoint);
	}

	@Override
	public Class<TrioLogger> getAnnotationClass() {
		return TrioLogger.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LoggerBeanConfig crateConfig(TrioLogger trioLogger) {
		LoggerBeanConfig loggerBeanConfig = new LoggerBeanConfig();
		
		AopStrategy<LoggerBeanConfig> aopStrategy = getBean(trioLogger.aopStrategy(), AopStrategy.class,getDefaultAopStrategy());
		Format format = getBean(trioLogger.format(), Format.class, getDefaultFormat());
		
		Map<String, Map<String, String>> config = new HashMap<String, Map<String, String>>();
		Map<String, String> levelName = new HashMap<String, String>();
		levelName.put(trioLogger.targetLevel(), trioLogger.targetName());
		config.put(trioLogger.targetTime(), levelName);

		loggerBeanConfig.setAsync(trioLogger.async());
		loggerBeanConfig.setTargetTimes(new String[] { trioLogger.targetTime() });
		loggerBeanConfig.setAopStrategy(aopStrategy);
		loggerBeanConfig.setFormat(format);
		loggerBeanConfig.setModelString(trioLogger.modelString());
		loggerBeanConfig.setConfig(config);
		return loggerBeanConfig;
	}

}
