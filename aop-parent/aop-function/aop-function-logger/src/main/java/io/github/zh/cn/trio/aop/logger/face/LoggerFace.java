package io.github.zh.cn.trio.aop.logger.face;

import io.github.zh.cn.trio.aop.logger.context.LoggerBeanContext;

public interface LoggerFace {

	public abstract void logger(LoggerBeanContext aopUtilContext, String targetTime);
}
