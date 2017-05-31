package com.zh.cn.trio.aop.utils.function.validation.strategy.error;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.function.validation.strategy.AbstartValidationResultStrategy;
import com.zh.cn.trio.aop.validation.bean.IReturnResult;

public class ErrorReturnValidationStrategy<E extends IReturnResult>
		extends AbstartValidationResultStrategy<ValidationBeanConfig, E> {

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
	public void operAop(AopUtilContext<ValidationBeanConfig> aopUtilContext, String targetTime) {
		IReturnResult validationResult = this.validationData(aopUtilContext);
		// 验证失败
		if (!validationResult.isSuccess()) {
			aopUtilContext.setResultObject(validationResult.getRerrorResult());
		}

	}
}