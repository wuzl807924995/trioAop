package io.github.zh.cn.trio.aop.logger.face;


import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.logger.config.LoggerBeanConfig;

public interface LoggerFace {

	public abstract void logger(AopUtilContext<LoggerBeanConfig> aopUtilContext,String targetTime);
}
