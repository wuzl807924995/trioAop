package io.github.zh.cn.trio.aop.logger.face.slf4j;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.croe.base.format.Format;
import com.zh.cn.trio.aop.croe.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.croe.context.AopUtilContext;

import io.github.zh.cn.trio.aop.logger.config.LoggerBeanConfig;
import io.github.zh.cn.trio.aop.logger.face.LoggerFace;

/**
 * 
 * slf4j 实现的日志
 *
 */
public class Slf4jLoggerFaceImpl implements LoggerFace {

	private Format format;

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public void logger(AopUtilContext<LoggerBeanConfig> aopUtilContext, String targetTime) {
		// 读配置
		Map<String, Map<String, String>> loggerConfig = aopUtilContext.getAopUtilConfig().getConfig();
		Map<String, String> config = loggerConfig.get(targetTime);
		// 填充之后的信息
		String info = getFormat().format(FormatConvertUtils.convertContext(aopUtilContext),
				aopUtilContext.getAopUtilConfig().getModelString());

		for (String level : config.keySet()) {
			String name = config.get(level);
			if (StringUtils.isEmpty(name)) {
				// 如果日志名称没有 默认使用类主日志
				name = aopUtilContext.getTarget().getClass().getName();
			}
			this.logger(level, name, info, aopUtilContext.getThrowable());
		}
	}

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
