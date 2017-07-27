package io.github.zh.cn.trio.aop.function.logger.context;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.function.logger.config.TrioLoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.face.LoggerFace;

/**
 * 
 * 日志配置
 */
public class LoggerBeanContext extends AopUtilContext {

	public static final String LEVEL_INFO = "INFO";
	public static final String LEVEL_ERROR = "ERROR";
	public static final String LEVEL_DEBUG = "DEBUG";
	public static final String LEVEL_WARN = "WARN";

	private TrioLoggerConfig trioLoggerConfig;

	private LoggerFace loggerFace;

	public LoggerFace getLoggerFace() {
		return loggerFace;
	}

	public void setLoggerFace(LoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}

	public TrioLoggerConfig getTrioLoggerConfig() {
		return trioLoggerConfig;
	}

	public void setTrioLoggerConfig(TrioLoggerConfig trioLoggerConfig) {
		this.trioLoggerConfig = trioLoggerConfig;
	}

	public String getLevel(String time) {
		return getTrioLoggerConfig().getTimeToLevelMap().get(time);
	}

	public String getName(String level) {
		return getTrioLoggerConfig().getLevelToNameMap().get(level);
	}

	public String getModel(String name) {
		return getTrioLoggerConfig().getNameToModelMap().get(name);
	}

}
