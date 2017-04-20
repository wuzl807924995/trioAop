package com.zh.cn.trio.aop.utils.strategy.function.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.zh.cn.trio.aop.utils.aspect.AbstractAopAspect;
import com.zh.cn.trio.aop.utils.bean.AopUtilBean;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public class LoggerXmlAspect extends AbstractAopAspect<LoggerConfig>{

	@Override
	public AopUtilBean<LoggerConfig> createBean(ProceedingJoinPoint proceedingJoinPoint,
			AopUtilContext<LoggerConfig> aopUtilContext) {
		return new AopUtilBean<LoggerConfig>();
	}

}
