package io.github.zh.cn.trio.aop.function.logger.aspect;

import java.util.Collection;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.function.logger.config.TrioLoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.context.LoggerBeanContext;

@Aspect
public class TrioLoggerXmlAspect extends AbstractTrioLoggerAspect {

	@Autowired
	private TrioLoggerConfig trioLoggerConfig;
	
	private boolean init=false;

	public TrioLoggerConfig getTrioLoggerConfig() {
		return trioLoggerConfig;
	}

	public void setTrioLoggerConfig(TrioLoggerConfig trioLoggerConfig) {
		this.trioLoggerConfig = trioLoggerConfig;
		
	}
	
	private void init(LoggerBeanContext loggerBeanContext) {
		Collection<String> levels = getTrioLoggerConfig().getTimeToLevelMap().values();
		Map<String, String> levelToNameMap = getTrioLoggerConfig().getLevelToNameMap();
		for (String level : levels) {
			levelToNameMap.put(level, getTargetName(loggerBeanContext, levelToNameMap.get(level)));
		}
		getTrioLoggerConfig().setLevelToNameMap(levelToNameMap);
		Map<String, String> nameToModelMap = getTrioLoggerConfig().getNameToModelMap();
		Collection<String> targetNames = levelToNameMap.values();
		for (String targetName : targetNames) {
			nameToModelMap.put(targetName, getModelString(nameToModelMap.get(targetName)));
		}
		getTrioLoggerConfig().setNameToModelMap(nameToModelMap);
		init=true;
	}
	

	@Override
	public LoggerBeanContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		LoggerBeanContext loggerBeanContext = new LoggerBeanContext();
		loggerBeanContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
		loggerBeanContext.setApplicationContext(getApplicationContext());

		AopStrategy aopStrategy = getDefaultLoggerAopStrategy();
		
		if (!init) {
			init(loggerBeanContext);
		}
		loggerBeanContext.setTrioLoggerConfig(getTrioLoggerConfig());
		loggerBeanContext.setLoggerFace(getDefaultLoggerFace());
		loggerBeanContext.setAopStrategy(aopStrategy);
		loggerBeanContext.setTargetTimes(getTrioLoggerConfig().getTargetTime());
		loggerBeanContext.setTrioLoggerConfig(getTrioLoggerConfig());
		return loggerBeanContext;
	}

}
