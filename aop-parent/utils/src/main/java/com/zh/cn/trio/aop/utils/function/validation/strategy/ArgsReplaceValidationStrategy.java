package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.validation.ArgsReplaceStrategy;

public class ArgsReplaceValidationStrategy extends ArgsReplaceStrategy<ValidationBeanConfig, ValidationResult> {

	@Override
	public Class<ValidationResult> getEClass() {
		return ValidationResult.class;
	}

	@Override
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		return getValidationFace().validationData(aopUtilContext);
	}

}
