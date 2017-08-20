package io.github.zh.cn.trio.aop.function.logger.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.logger.config.LoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.face.LoggerFace;

public class LoggerAdapter implements RunTimeAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private LoggerFace loggerFace;

	public LoggerFace getLoggerFace() {
		return loggerFace;
	}

	public void setLoggerFace(LoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}

	@Override
	public void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		if (runTimeConfig instanceof LoggerConfig) {
			LoggerConfig loggerConfig = (LoggerConfig) runTimeConfig;
			loggerFace.logger(runTimeContext, loggerConfig, targetTime);
		} else {
			logger.warn(runTimeConfig + "is not LoggerConfig");
		}
	}
}
