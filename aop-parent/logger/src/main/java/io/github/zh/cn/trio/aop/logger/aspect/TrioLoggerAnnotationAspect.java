package io.github.zh.cn.trio.aop.logger.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.annotation.AbstractAnnotationConfigAspect;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.logger.config.LoggerBeanConfig;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAnnotationConfigAspect<LoggerBeanConfig,TrioLogger> {



	@Around("@annotation(io.github.zh.cn.trio.aop.logger.annotation.TrioLogger)")
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
		
		Map<String, Map<String, String>> config = new HashMap<String, Map<String, String>>();
		Map<String, String> levelName = new HashMap<String, String>();
		levelName.put(trioLogger.targetLevel(), trioLogger.targetName());
		config.put(trioLogger.targetTime(), levelName);

		loggerBeanConfig.setTargetTimes(new String[] { trioLogger.targetTime() });
		loggerBeanConfig.setAopStrategy(aopStrategy);
		loggerBeanConfig.setModelString(trioLogger.modelString());
		loggerBeanConfig.setConfig(config);
		return loggerBeanConfig;
	}

}
