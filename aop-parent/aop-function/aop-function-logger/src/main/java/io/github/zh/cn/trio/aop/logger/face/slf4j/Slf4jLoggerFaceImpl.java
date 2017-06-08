package io.github.zh.cn.trio.aop.logger.face.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.utils.FormatConvertUtils;
import io.github.zh.cn.trio.aop.logger.context.LoggerBeanContext;
import io.github.zh.cn.trio.aop.logger.face.AbstarctLoggerFace;
import io.github.zh.cn.trio.aop.plug.format.Format;
import io.github.zh.cn.trio.aop.plug.format.bean.FormatBean;

/**
 * 
 * slf4j 实现的日志
 *
 */
public class Slf4jLoggerFaceImpl extends AbstarctLoggerFace {

	@Override
	public void logger(LoggerBeanContext aopUtilContext, String targetTime) {
		// 读配置
		String level = aopUtilContext.getLevel(targetTime);
		String name = aopUtilContext.getName(level);
		String model = aopUtilContext.getModel(name);
		Format format = aopUtilContext.getFormat();
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String info = format.format(formatBean, model);
		logger(level, name, info, aopUtilContext.getThrowable());
	}

	public void logger(String level, String name, String info, Throwable e) {
		Logger logger = LoggerFactory.getLogger(name);
		switch (level) {
		case LoggerBeanContext.LEVEL_DEBUG:
			logger.debug(info, e);
			break;
		case LoggerBeanContext.LEVEL_INFO:
			logger.info(info, e);
			break;
		case LoggerBeanContext.LEVEL_ERROR:
			logger.error(info, e);
			break;
		case LoggerBeanContext.LEVEL_WARN:
			logger.warn(info, e);
			break;
		default:
			logger.debug(info, e);
			break;
		}
	}

}
