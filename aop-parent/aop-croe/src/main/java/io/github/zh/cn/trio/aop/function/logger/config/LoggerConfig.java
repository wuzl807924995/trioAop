package io.github.zh.cn.trio.aop.function.logger.config;

import java.util.ArrayList;
import java.util.List;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.function.logger.config.bean.LoggerOne;

public class LoggerConfig extends RunTimeConfig {

	public static final String LEVEL_INFO = "INFO";
	public static final String LEVEL_ERROR = "ERROR";
	public static final String LEVEL_DEBUG = "DEBUG";
	public static final String LEVEL_WARN = "WARN";

	private List<LoggerOne> loggerList;

	public List<LoggerOne> getLoggerList() {
		return loggerList;
	}

	public void setLoggerList(List<LoggerOne> loggerList) {
		this.loggerList = loggerList;
	}

	
	public void addOne(LoggerOne loggerOne) {
		if (loggerList==null) {
			loggerList=new ArrayList<>();
		}
		loggerList.add(loggerOne);
	}
	
	
}
