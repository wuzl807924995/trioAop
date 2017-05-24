package com.zh.cn.trio.aop.utils.function.logger.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;

/**
 * 	
 * slf4j 实现的日志
 *
 */
public class Slf4jLoggerFaceImpl implements LoggerFace {

	@Override
	public void logger(String level, String name, String info, Throwable e) {
		Logger logger = LoggerFactory.getLogger(name);
		switch (level) {
		case LoggerBeanConfig.LEVEL_DEBUG:
			logger.debug(info, e);
			break;
		case LoggerBeanConfig.LEVEL_INFO:
			logger.info(info, e);
			break;
		case LoggerBeanConfig.LEVEL_ERROR:
			logger.error(info, e);
			break;
		case LoggerBeanConfig.LEVEL_WARN:
			logger.warn(info, e);
			break;
		default:
			logger.debug(info, e);
			break;
		}
	}

}
