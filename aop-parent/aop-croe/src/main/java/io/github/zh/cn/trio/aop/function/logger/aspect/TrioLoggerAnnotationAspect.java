package io.github.zh.cn.trio.aop.function.logger.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.logger.adapter.LoggerAdapter;
import io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.function.logger.config.LoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.config.bean.LoggerOne;
import io.github.zh.cn.trio.aop.plug.format.Format;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAopAspect {

	private LoggerAdapter loggerAdapter;

	private String defaultModelString;
	
	private Format format;

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
	
	public Format getFormat() {
		return format;
	}
	
	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public RunTimeConfig initConfig(RunTimeContext runTimeContext) {
		TrioLogger trioLogger = runTimeContext.getAnnotation(TrioLogger.class);

		LoggerConfig loggerConfig = new LoggerConfig();
		loggerConfig.setRunTimeAdapter(loggerAdapter);
		loggerConfig.setTargetTimes(new String[] { trioLogger.targetTime() });

		String targetName=StringUtils.isEmpty(trioLogger.targetName())?runTimeContext.getTarget().getClass().getName():trioLogger.targetName();
		String model = StringUtils.isEmpty(trioLogger.modelString()) ? defaultModelString : trioLogger.modelString();
		model=format.format(runTimeContext, loggerConfig, model);
		LoggerOne loggerOne = new LoggerOne(trioLogger.targetLevel(), targetName,model);

		loggerConfig.addOne(loggerOne);
		return loggerConfig;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}
}
