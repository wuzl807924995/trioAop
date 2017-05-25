package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.validation.ArgsReplaceStrategy;

public class ArgsReplaceValidationStrategy extends ArgsReplaceStrategy<ValidationBeanConfig> {

	@Override
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		ValidationFace validationFace = aopUtilContext.getAopUtilConfig().getValidationFace();
		return validationFace.validationData(aopUtilContext);
	}

}
