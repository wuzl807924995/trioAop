package io.github.zh.cn.trio.aop.function.logger.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.logger.adapter.LoggerAdapter;
import io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.function.logger.config.LoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.config.bean.LoggerOne;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAopAspect {

	private LoggerAdapter loggerAdapter;

	private String defaultModelString;

	public LoggerAdapter getLoggerAdapter() {
		return loggerAdapter;
	}

	public void setLoggerAdapter(LoggerAdapter loggerAdapter) {
		this.loggerAdapter = loggerAdapter;
	}

	public String getDefaultModelString() {
		return defaultModelString;
	}

	public void setDefaultModelString(String defaultModelString) {
		this.defaultModelString = defaultModelString;
	}

	@Override
	public RunTimeConfig initConfig(RunTimeContext runTimeContext) {
		TrioLogger trioLogger = runTimeContext.getAnnotation(TrioLogger.class);

		LoggerConfig loggerConfig = new LoggerConfig();
		loggerConfig.setRunTimeAdapter(loggerAdapter);
		loggerConfig.setTargetTimes(new String[] { trioLogger.targetTime() });

		String model = "".equals(trioLogger.modelString()) ? defaultModelString : trioLogger.modelString();
		LoggerOne loggerOne = new LoggerOne(trioLogger.targetTime(), trioLogger.targetLevel(), trioLogger.targetName(),
				model);

		loggerConfig.addOne(loggerOne);
		return loggerConfig;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}
}
