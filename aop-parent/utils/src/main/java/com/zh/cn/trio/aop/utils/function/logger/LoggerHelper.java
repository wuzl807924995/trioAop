package com.zh.cn.trio.aop.utils.function.logger;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.logger.config.LoggerBeanConfig;

/**
 * 
 * 日志打印帮助类
 *
 */
public abstract class LoggerHelper {

	public static void logger(AopUtilContext<LoggerBeanConfig> aopUtilContext, String targetTime) {
		//读配置
		Map<String, Map<String, String>> loggerConfig = aopUtilContext.getAopUtilConfig().getConfig();
		Map<String, String> config = loggerConfig.get(targetTime);
		//填充之后的信息
		String info = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext), aopUtilContext.getAopUtilConfig().getModelString());
		LoggerFace loggerFace = aopUtilContext.getAopUtilConfig().getLoggerFace();

		for (String level : config.keySet()) {
			String name = config.get(level);
			if (StringUtils.isEmpty(name)) {
				//如果日志名称没有  默认使用类主日志
				name = aopUtilContext.getTarget().getClass().getName();
			}
			loggerFace.logger(level, name, info, aopUtilContext.getThrowable());
		}
	}
}
