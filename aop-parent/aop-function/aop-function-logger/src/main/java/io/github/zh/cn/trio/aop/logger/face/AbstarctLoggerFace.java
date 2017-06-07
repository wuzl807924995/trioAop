package io.github.zh.cn.trio.aop.logger.face;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;
import io.github.zh.cn.trio.aop.logger.context.LoggerBeanContext;

public abstract class AbstarctLoggerFace implements LoggerFace,AbsBeanModel{

	
	public void beforeAop(AbsContext context){
		logger((LoggerBeanContext) context,AbsContext.TIME_BEFORE);
	}

	public void afertAop(AbsContext context){
		logger((LoggerBeanContext) context,AbsContext.TIME_AFTER);
	}

	public void errorAop(AbsContext context){
		logger((LoggerBeanContext) context,AbsContext.TIME_BEFORE);
	}
}
