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
	

	@Deprecated
	public TrioLoggerConfig getTrioLoggerConfig() {
		return trioLoggerConfig;
	}

	public void setTrioLoggerConfig(TrioLoggerConfig trioLoggerConfig) {
		this.trioLoggerConfig = trioLoggerConfig;
		
	}
	
	public TrioLoggerConfig getTrioLoggerConfigCopy(){
		TrioLoggerConfig trioLoggerConfig=new TrioLoggerConfig();
		trioLoggerConfig.setLevelToNameMap(this.trioLoggerConfig.getLevelToNameMap());
		trioLoggerConfig.setNameToModelMap(this.trioLoggerConfig.getNameToModelMap());
		trioLoggerConfig.setTimeToLevelMap(this.trioLoggerConfig.getTimeToLevelMap());
		return trioLoggerConfig;
	}
	
	private void init(LoggerBeanContext loggerBeanContext) {
		Collection<String> levels =loggerBeanContext.getTrioLoggerConfig().getTimeToLevelMap().values();
		Map<String, String> levelToNameMap = loggerBeanContext.getTrioLoggerConfig().getLevelToNameMap();
		for (String level : levels) {
			levelToNameMap.put(level, getTargetName(loggerBeanContext,null));
		}
		loggerBeanContext.getTrioLoggerConfig().setLevelToNameMap(levelToNameMap);
		Map<String, String> nameToModelMap = loggerBeanContext.getTrioLoggerConfig().getNameToModelMap();
		Collection<String> targetNames = levelToNameMap.values();
		for (String targetName : targetNames) {
			nameToModelMap.put(targetName, getModelString(nameToModelMap.get(targetName)));
		}
		loggerBeanContext.getTrioLoggerConfig().setNameToModelMap(nameToModelMap);
	}
	

	@Override
	public LoggerBeanContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		LoggerBeanContext loggerBeanContext = new LoggerBeanContext();
		loggerBeanContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
		loggerBeanContext.setApplicationContext(getApplicationContext());

		AopStrategy aopStrategy = getDefaultLoggerAopStrategy();
		
		loggerBeanContext.setTrioLoggerConfig(getTrioLoggerConfigCopy());
		init(loggerBeanContext);
		loggerBeanContext.setLoggerFace(getDefaultLoggerFace());
		loggerBeanContext.setAopStrategy(aopStrategy);
		loggerBeanContext.setTargetTimes(loggerBeanContext.getTrioLoggerConfig().getTargetTime());
		loggerBeanContext.setTrioLoggerConfig(loggerBeanContext.getTrioLoggerConfig());
		return loggerBeanContext;
	}

}
