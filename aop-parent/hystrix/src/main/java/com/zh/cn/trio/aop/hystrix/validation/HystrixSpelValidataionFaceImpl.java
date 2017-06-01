package com.zh.cn.trio.aop.hystrix.validation;

import com.zh.cn.trio.aop.hystrix.model.HystrixModel;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;
import io.github.zh.cn.trio.aop.validation.face.ValidationFace;

public class HystrixSpelValidataionFaceImpl implements ValidationFace<HystrixResult> {

	public HystrixResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		HystrixModel hystrixModel = aopUtilContext.getApplicationContext()
				.getBean(aopUtilContext.getAopUtilConfig().getExpression()[0], HystrixModel.class);
		return hystrixModel.hystrixValidation(aopUtilContext.getTarget(), aopUtilContext.getTargetMethod(),
				aopUtilContext.getTargetArgs());
	}

}
