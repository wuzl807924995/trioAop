package com.zh.cn.trio.aop.hystrix.validation;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.hystrix.model.HystrixModel;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

public class HystrixSpelValidataionFaceImpl implements ValidationFace<HystrixResult> {

	public HystrixResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		HystrixModel hystrixModel = aopUtilContext.getApplicationContext().getBean(aopUtilContext.getAopUtilConfig().getExpression()[0], HystrixModel.class);
		return hystrixModel.hystrixValidation(aopUtilContext.getTarget(), aopUtilContext.getTargetMethod(),aopUtilContext.getTargetArgs());
	}

}
