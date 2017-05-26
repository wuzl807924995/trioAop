package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.validation.ArgsReplaceStrategy;

public class ArgsReplaceValidationStrategy extends ArgsReplaceStrategy<ValidationBeanConfig,ValidationResult> {

	/**
	 * 验证接口
	 */
	private ValidationFace validationFace;
	
	public ValidationFace getValidationFace() {
		return validationFace;
	}
	
	public void setValidationFace(ValidationFace validationFace) {
		this.validationFace = validationFace;
	}
	
	@Override
	public Class<ValidationResult> getEClass() {
		return ValidationResult.class;
	}
	
	@Override
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		ValidationFace validationFace = getValidationFace();
		return validationFace.validationData(aopUtilContext);
	}

}
