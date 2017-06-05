package io.github.zh.cn.trio.aop.config.bean.cls.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.config.bean.cls.context.BeanClassContext;
import io.github.zh.cn.trio.aop.config.bean.cls.model.BeanClassModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public class BeanClassConfigStrategy implements AopStrategy {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		BeanClassContext beanClassContext = (BeanClassContext) aopUtilContext;
		BeanClassModel beanClassModel = beanClassContext.getBeanModel();

		if (AopUtilContext.TIME_BEFORE.equals(targetTime)) {
			beanClassModel.beforeAop(beanClassContext);
		} else if (AopUtilContext.TIME_AFTER.equals(targetTime)) {
			beanClassModel.afertAop(beanClassContext);
		} else if (AopUtilContext.TIME_ERROR.equals(targetTime)) {
			beanClassModel.errorAop(beanClassContext);
		} else {
			logger.error("operAop has not time to target ");
		}
	}

}
