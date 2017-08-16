package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

public abstract class AbstractErrorRetrunValidation implements ValidationFace {

	@Override
	public void doValidation(RunTimeContext context, RunTimeConfig runTimeConfig) {
		IReturnResult<?> iReturnResult = validation(context,runTimeConfig);
		if (!iReturnResult.isSuccess() && iReturnResult.getErrorResult() != null
				&& context.getReturnClass().equals(iReturnResult.getErrorResult().getClass())) {
			context.setResultObject(iReturnResult.getErrorResult());
		}
	}
}
