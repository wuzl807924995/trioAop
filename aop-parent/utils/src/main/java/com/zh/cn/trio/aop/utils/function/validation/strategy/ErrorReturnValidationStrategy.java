package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.validation.ErrorReturnStrategy;

public class ErrorReturnValidationStrategy<E extends IValidationResult> extends ErrorReturnStrategy<ValidationBeanConfig>{

	

	/**
	 * 验证接口
	 */
	private ValidationFace<E> validationFace;

	public ValidationFace<E> getValidationFace() {
		return validationFace;
	}
	
	public void setValidationFace(ValidationFace<E> validationFace) {
		this.validationFace = validationFace;
	}


	@Override
	public E validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		return getValidationFace().validationData(aopUtilContext);
	}

	
	@Override
	public String getErrorMsgFormatString(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		return aopUtilContext.getAopUtilConfig().getErrorResult();
	}
	
}