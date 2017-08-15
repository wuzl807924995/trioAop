package io.github.zh.cn.trio.aop.function.logger.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.logger.config.LoggerConfig;

public interface LoggerFace {

	void logger(RunTimeContext runTimeContext, LoggerConfig loggerConfig, String targetTime);
}
