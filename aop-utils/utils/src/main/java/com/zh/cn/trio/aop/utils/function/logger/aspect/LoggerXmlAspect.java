package com.zh.cn.trio.aop.utils.function.logger.aspect;

import com.zh.cn.trio.aop.utils.aspect.AbstractAopAspect;
import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;

public class LoggerXmlAspect extends AbstractAopAspect<LoggerConfig> {

	private LoggerConfig loggerConfig;

	
	
	public LoggerConfig getLoggerConfig() {
		return loggerConfig;
	}



	public void setLoggerConfig(LoggerConfig loggerConfig) {
		this.loggerConfig = loggerConfig;
	}



	@Override
	public LoggerConfig createBean(AopUtilContext<LoggerConfig> aopUtilContext) {
		return loggerConfig;
	}

}
