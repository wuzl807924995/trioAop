package io.github.zh.cn.trio.aop.config.bean.cls.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.config.bean.cls.context.BeanClassConfig;
import io.github.zh.cn.trio.aop.config.bean.cls.model.BeanClassModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public class BeanClassConfigStrategy implements AopStrategy {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		BeanClassConfig beanClassConfig = (BeanClassConfig) aopUtilContext;
		BeanClassModel beanClassModel = beanClassConfig.getBeanModel();

		if (AopUtilContext.TIME_BEFORE.equals(targetTime)) {
			beanClassModel.beforeAop(beanClassConfig);
		} else if (AopUtilContext.TIME_AFTER.equals(targetTime)) {
			beanClassModel.afertAop(beanClassConfig);
		} else if (AopUtilContext.TIME_ERROR.equals(targetTime)) {
			beanClassModel.errorAop(beanClassConfig);
		} else {
			logger.error("operAop has not time to target ");
		}
	}

}
