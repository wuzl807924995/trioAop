package com.zh.cn.trio.aop.utils.function.logger;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;

public abstract class LoggerHelper {

	public static void logger(AopUtilContext<LoggerBeanConfig> aopUtilContext, String targetTime) {
		Map<String, Map<String, String>> loggerConfig = aopUtilContext.getAopUtilConfig().getConfig();
		Map<String, String> config = loggerConfig.get(targetTime);
		String info = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext), aopUtilContext.getAopUtilConfig().getFormatString());
		LoggerFace loggerFace = aopUtilContext.getAopUtilConfig().getLoggerFace();

		for (String level : config.keySet()) {
			String name = config.get(level);
			if (StringUtils.isEmpty(name)) {
				name = aopUtilContext.getTarget().getClass().getName();
			}
			loggerFace.logger(level, name, info, aopUtilContext.getThrowable());
		}
	}
}
