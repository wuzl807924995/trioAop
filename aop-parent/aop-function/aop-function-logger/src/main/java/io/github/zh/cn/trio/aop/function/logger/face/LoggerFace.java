package io.github.zh.cn.trio.aop.function.logger.face;

import io.github.zh.cn.trio.aop.function.logger.context.LoggerBeanContext;

public interface LoggerFace {

	public abstract void logger(LoggerBeanContext aopUtilContext, String targetTime);
}
