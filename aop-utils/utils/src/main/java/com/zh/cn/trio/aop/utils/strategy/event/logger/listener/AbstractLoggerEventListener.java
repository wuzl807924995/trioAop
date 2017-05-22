package com.zh.cn.trio.aop.utils.strategy.event.logger.listener;

import com.zh.cn.trio.aop.utils.function.logger.LoggerHelper;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.event.AbstartAopListener;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public abstract class AbstractLoggerEventListener extends AbstartAopListener<LoggerBeanConfig> {

	public void onEvent(AopEvent<LoggerBeanConfig> event) {
		LoggerHelper.logger(event.getAopUtilContext(), event.getTargetTime());
	}

}
