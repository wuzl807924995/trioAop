package io.github.zh.cn.trio.aop.function.logger.face.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.logger.config.LoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.config.bean.LoggerOne;
import io.github.zh.cn.trio.aop.function.logger.face.LoggerFace;

@Component
public class Sl4jLoggerImpl implements LoggerFace {

	@Override
	public void logger(RunTimeContext runTimeContext, LoggerConfig loggerConfig, String targetTime) {
		List<LoggerOne> list = loggerConfig.getLoggerList();
		if (!CollectionUtils.isEmpty(list)) {
			for (LoggerOne loggerOne : list) {
				if (targetTime.equals(loggerOne.getTime())) {
					logger(loggerOne.getLevel(), loggerOne.getName(), loggerOne.getInfo(), runTimeContext.getThrowable());
				}
			}
		}
	}

	public void logger(String level, String name, String info, Throwable e) {
		Logger logger = LoggerFactory.getLogger(name);
		switch (level) {
		case LoggerConfig.LEVEL_DEBUG:
			logger.debug(info, e);
			break;
		case LoggerConfig.LEVEL_INFO:
			logger.info(info, e);
			break;
		case LoggerConfig.LEVEL_ERROR:
			logger.error(info, e);
			break;
		case LoggerConfig.LEVEL_WARN:
			logger.warn(info, e);
			break;
		default:
			logger.debug(info, e);
			break;
		}
	}

}
