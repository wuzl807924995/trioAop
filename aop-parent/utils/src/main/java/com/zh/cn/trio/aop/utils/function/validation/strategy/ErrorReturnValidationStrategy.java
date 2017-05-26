package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.validation.ErrorReturnStrategy;

public class ErrorReturnValidationStrategy extends ErrorReturnStrategy<ValidationBeanConfig>{

	

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
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		ValidationFace validationFace =getValidationFace();
		return validationFace.validationData(aopUtilContext);
	}

	
	@Override
	public String getErrorMsgFormatString(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		return aopUtilContext.getAopUtilConfig().getErrorResult();
	}
	
}