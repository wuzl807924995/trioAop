package io.github.zh.cn.trio.aop.function.logger.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.function.logger.context.LoggerBeanContext;
import io.github.zh.cn.trio.aop.function.logger.face.LoggerFace;
import io.github.zh.cn.trio.aop.function.logger.strategy.LoggerStrategy;

/**
 * 日志抽象aop
 * @author wuzl
 *
 */
public abstract class AbstractTrioLoggerAspect extends AbstractAopAspect<LoggerBeanContext> {

	@Autowired
	private LoggerStrategy defaultLoggerStrategy;

	@Autowired
	private LoggerFace defaultLoggerFace;

	private String defaultKeyModelString = "'method:'+getTargetMethod()+':args:'+getTargetArgs().toString()";

	public LoggerStrategy getDefaultLoggerStrategy() {
		return defaultLoggerStrategy;
	}

	public void setDefaultLoggerStrategy(LoggerStrategy defaultLoggerStrategy) {
		this.defaultLoggerStrategy = defaultLoggerStrategy;
	}

	public LoggerFace getDefaultLoggerFace() {
		return defaultLoggerFace;
	}

	public void setDefaultLoggerFace(LoggerFace defaultLoggerFace) {
		this.defaultLoggerFace = defaultLoggerFace;
	}

	public String getDefaultKeyModelString() {
		return defaultKeyModelString;
	}

	public void setDefaultKeyModelString(String defaultKeyModelString) {
		this.defaultKeyModelString = defaultKeyModelString;
	}

	public String getTargetName(LoggerBeanContext loggerBeanContext, String targetName) {
		if (StringUtils.isEmpty(targetName)) {
			return loggerBeanContext.getTarget().getClass().getName();
		}
		return targetName;
	}

	public String getModelString(String modelString) {
		if (StringUtils.isEmpty(modelString)) {
			return getDefaultKeyModelString();
		}
		return modelString;
	}
}
