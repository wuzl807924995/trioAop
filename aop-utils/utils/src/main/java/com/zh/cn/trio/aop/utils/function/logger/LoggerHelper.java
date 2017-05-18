package com.zh.cn.trio.aop.utils.function.logger;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.logger.aspect.LoggerConfig;

public abstract class LoggerHelper {

	public static void logger(AopUtilContext<LoggerConfig> aopUtilContext, String targetTime) {
		Map<String, Map<String, String>> loggerConfig = aopUtilContext.getAopUtilConfig().getConfig();
		Map<String, String> config = loggerConfig.get(targetTime);
		String info = aopUtilContext.getAopUtilConfig().getFormat().formatContextToString(aopUtilContext);
		LoggerFace loggerFace = aopUtilContext.getAopUtilConfig().getLoggerFace();

		
		
		for (String level : config.keySet()) {
			String name = config.get(level);
			if (StringUtils.isEmpty(name)) {
				name=aopUtilContext.getProceedingJoinPoint().getTarget().getClass().getName();
			}
			loggerFace.logger(level,name, info, aopUtilContext.getThrowable());
		}
	}
}
