package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.config.ValidationConfig;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

public abstract class AbstractErrorRetrunValidation implements ValidationFace {

	/**
	 * 如果验证失败，并且验证返回信息和方法签名一直的话将不执行方法直接返回错误信息
	 */
	@Override
	public void doValidation(RunTimeContext context, ValidationConfig validationConfig) {
		IReturnResult<?> iReturnResult = validation(context,validationConfig);
		if (!iReturnResult.isSuccess() && iReturnResult.getErrorResult() != null
				&& context.getReturnClass().equals(iReturnResult.getErrorResult().getClass())) {
			context.setResultObject(iReturnResult.getErrorResult());
		}
	}
}
