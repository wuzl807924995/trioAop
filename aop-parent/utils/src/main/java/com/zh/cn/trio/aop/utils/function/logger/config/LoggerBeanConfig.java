package com.zh.cn.trio.aop.utils.function.logger.config;

import java.util.Map;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;

/**
 * 	
 *	日志配置
 */
public class LoggerBeanConfig extends AopUtilConfig<LoggerBeanConfig> {

	public static final String LEVEL_INFO = "INFO";
	public static final String LEVEL_ERROR = "ERROR";
	public static final String LEVEL_DEBUG = "DEBUG";
	public static final String LEVEL_WARN = "WARN";

	/**
	 * 日志接口
	 */
	private LoggerFace loggerFace;

	/** time->levels->name */
	private Map<String, Map<String, String>> config;
	
	/**
	 * 日志模板
	 */
	private String modelString;

	public Map<String, Map<String, String>> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Map<String, String>> config) {
		this.config = config;
	}

	public LoggerFace getLoggerFace() {
		return loggerFace;
	}

	public void setLoggerFace(LoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}

	public String getModelString() {
		return modelString;
	}

	public void setModelString(String modelString) {
		this.modelString = modelString;
	}

	
}
