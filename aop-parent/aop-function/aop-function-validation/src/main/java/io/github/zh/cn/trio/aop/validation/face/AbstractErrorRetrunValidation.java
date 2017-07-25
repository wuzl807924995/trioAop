package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.validation.context.ValidationBeanContext;
import io.github.zh.cn.trio.aop.validation.result.IReturnResult;

public abstract class AbstractErrorRetrunValidation implements ValidationFace {

	@Override
	public void doValidation(ValidationBeanContext context) {
		IReturnResult<?> iReturnResult = validation(context);
		if (!iReturnResult.isSuccess() && iReturnResult.getErrorResult() != null
				&& context.getReturnClass().equals(iReturnResult.getErrorResult().getClass())) {
			context.setResultObject(iReturnResult.getErrorResult());
		}
	}
}
