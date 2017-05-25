package com.zh.cn.trio.aop.logger.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.zh.cn.trio.aop.logger.annotation.TrioLogger;
import com.zh.cn.trio.aop.utils.aspect.AbstractAnnotationAspect;
import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAnnotationAspect<LoggerBeanConfig,TrioLogger> {


	private AopStrategy<LoggerBeanConfig> defaultAopStrategy;

	private Format defaultFormat;

	private LoggerFace defaultLoggerFace;

	public AopStrategy<LoggerBeanConfig> getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy<LoggerBeanConfig> defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

	public Format getDefaultFormat() {
		return defaultFormat;
	}

	public void setDefaultFormat(Format defaultFormat) {
		this.defaultFormat = defaultFormat;
	}

	public LoggerFace getDefaultLoggerFace() {
		return defaultLoggerFace;
	}

	public void setDefaultLoggerFace(LoggerFace defaultLoggerFace) {
		this.defaultLoggerFace = defaultLoggerFace;
	}

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
		
		AopStrategy<LoggerBeanConfig> aopStrategy = getBean(trioLogger.aopStrategy(), AopStrategy.class,defaultAopStrategy);
		Format format = getBean(trioLogger.format(), Format.class, defaultFormat);
		LoggerFace loggerFace = getBean(trioLogger.loggerFace(), LoggerFace.class, defaultLoggerFace);
		
		Map<String, Map<String, String>> config = new HashMap<String, Map<String, String>>();
		Map<String, String> levelName = new HashMap<String, String>();
		levelName.put(trioLogger.targetLevel(), trioLogger.targetName());
		config.put(trioLogger.targetTime(), levelName);

		loggerBeanConfig.setAsync(trioLogger.async());
		loggerBeanConfig.setTargetTimes(new String[] { trioLogger.targetTime() });
		loggerBeanConfig.setAopStrategy(aopStrategy);
		loggerBeanConfig.setFormat(format);
		loggerBeanConfig.setLoggerFace(loggerFace);
		loggerBeanConfig.setModelString(trioLogger.modelString());
		loggerBeanConfig.setConfig(config);
		return loggerBeanConfig;
	}

}
