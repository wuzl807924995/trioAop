package io.github.zh.cn.trio.aop.config.bean.name.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.config.bean.name.context.BeanNameConfig;
import io.github.zh.cn.trio.aop.config.bean.name.model.BeanNameModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public class BeanNameConfigStrategy implements AopStrategy {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		BeanNameConfig beanNameConfig = (BeanNameConfig) aopUtilContext;
		BeanNameModel beanNameModel = beanNameConfig.getBeanModel();
		if (AopUtilContext.TIME_BEFORE.equals(targetTime)) {
			beanNameModel.beforeAop(beanNameConfig);
		} else if (AopUtilContext.TIME_AFTER.equals(targetTime)) {
			beanNameModel.afertAop(beanNameConfig);
		} else if (AopUtilContext.TIME_ERROR.equals(targetTime)) {
			beanNameModel.errorAop(beanNameConfig);
		} else {
			logger.error("operAop has not time to target ");
		}
	}

}
