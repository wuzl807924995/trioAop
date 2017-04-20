package com.zh.cn.trio.aop.utils.strategy.function.logger.listener;

import org.springframework.context.ApplicationListener;

import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;
import com.zh.cn.trio.aop.utils.strategy.function.logger.aspect.LoggerConfig;

public class LoggerEventListener implements ApplicationListener<AopEvent<LoggerConfig>>{

	@Override
	public void onApplicationEvent(AopEvent<LoggerConfig> event) {
		System.err.println("EventLogger");
	}

}
