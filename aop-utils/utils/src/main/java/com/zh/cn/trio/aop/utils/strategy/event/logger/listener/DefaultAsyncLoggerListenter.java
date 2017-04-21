package com.zh.cn.trio.aop.utils.strategy.event.logger.listener;

import org.springframework.scheduling.annotation.Async;

import com.zh.cn.trio.aop.utils.function.logger.aspect.LoggerConfig;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public class DefaultAsyncLoggerListenter extends AbstractLoggerEventListener {

	@Async
	@Override
	public void onApplicationEvent(AopEvent<LoggerConfig> event) {
		onEvent(event, true);
	}

}