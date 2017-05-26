package com.zh.cn.trio.aop.utils.strategy.event.logger.listener;

import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;
import com.zh.cn.trio.aop.utils.function.logger.LoggerHelper;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.event.AbstartAopListener;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public abstract class AbstractLoggerEventListener extends AbstartAopListener<LoggerBeanConfig> {

	private LoggerFace loggerFace;
	
	
	
	public LoggerFace getLoggerFace() {
		return loggerFace;
	}



	public void setLoggerFace(LoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}



	public void onEvent(AopEvent<LoggerBeanConfig> event) {
		LoggerHelper.logger(loggerFace,event.getAopUtilContext(), event.getTargetTime());
	}

}
