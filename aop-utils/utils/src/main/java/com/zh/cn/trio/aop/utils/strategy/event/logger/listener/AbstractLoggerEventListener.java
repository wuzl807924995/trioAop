package com.zh.cn.trio.aop.utils.strategy.event.logger.listener;

import java.util.Map;

import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;
import com.zh.cn.trio.aop.utils.function.logger.aspect.LoggerConfig;
import com.zh.cn.trio.aop.utils.strategy.event.AbstartAopListener;
import com.zh.cn.trio.aop.utils.strategy.event.AopEvent;

public abstract class AbstractLoggerEventListener extends AbstartAopListener<LoggerConfig> {

	public void onEvent(AopEvent<LoggerConfig> event) {
		Map<String, Map<String, String>> loggerConfig = event.getAopUtilContext().getAopUtilConfig().getConfig();
		Map<String, String> config = loggerConfig.get(event.getTargetTime());
		String info = event.getAopUtilContext().getAopUtilConfig().getFormat()
				.formatContextToString(event.getAopUtilContext());
		LoggerFace loggerFace = event.getAopUtilContext().getAopUtilConfig().getLoggerFace();

		for (String level : config.keySet()) {
			logger(loggerFace, level, config.get(level), info, event.getAopUtilContext().getThrowable());
		}
	}

	public void logger(LoggerFace loggerFace, String level, String name, String info, Throwable e) {
		loggerFace.logger(level, name, info, e);
	}

}
