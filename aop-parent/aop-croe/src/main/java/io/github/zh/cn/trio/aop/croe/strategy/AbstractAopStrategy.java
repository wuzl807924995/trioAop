package io.github.zh.cn.trio.aop.croe.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public abstract class AbstractAopStrategy implements AopStrategy{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		if (AopUtilContext.TIME_BEFORE.equals(targetTime)) {
			beforeAop(aopUtilContext);
		} else if (AopUtilContext.TIME_AFTER.equals(targetTime)) {
			afertAop(aopUtilContext);
		} else if (AopUtilContext.TIME_ERROR.equals(targetTime)) {
			errorAop(aopUtilContext);
		} else {
			logger.error("operAop has not time to target ");
		}
	}

	public void errorAop(AopUtilContext aopUtilContext) {

	}

	public void afertAop(AopUtilContext aopUtilContext) {

	}

	public void beforeAop(AopUtilContext aopUtilContext) {

	}
}
