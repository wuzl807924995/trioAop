package com.zh.cn.trio.aop.utils.strategy.event.logger.listener;

import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public class DefaultSyncLoggerListenter extends AbstractLoggerEventListener {

	@Override
	public void onApplicationEvent(AopEvent<LoggerBeanConfig> event) {
		onEvent(event, false);
	}

}
