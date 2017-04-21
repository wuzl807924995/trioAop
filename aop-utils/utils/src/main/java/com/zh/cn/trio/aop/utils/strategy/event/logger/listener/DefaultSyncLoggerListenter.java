package com.zh.cn.trio.aop.utils.strategy.event.logger.listener;

import com.zh.cn.trio.aop.utils.function.logger.aspect.LoggerConfig;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public class DefaultSyncLoggerListenter extends AbstractLoggerEventListener {

	@Override
	public void onApplicationEvent(AopEvent<LoggerConfig> event) {
		onEvent(event, false);
	}

}
