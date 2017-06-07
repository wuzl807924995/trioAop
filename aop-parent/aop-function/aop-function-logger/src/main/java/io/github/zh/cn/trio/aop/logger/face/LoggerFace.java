package io.github.zh.cn.trio.aop.logger.face;

import io.github.zh.cn.trio.aop.logger.config.LoggerBeanConfig;

public interface LoggerFace {

	public abstract void logger(LoggerBeanConfig aopUtilContext, String targetTime);
}
