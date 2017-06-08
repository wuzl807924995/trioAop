package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.validation.result.IReturnResult;

public abstract class AbstractErrorRetrunValidation extends AbstractValidationFace {

	@Override
	public void beforeAop(AbsContext context) {
		IReturnResult<Object> iReturnResult = validation(context);
		if (!iReturnResult.isSuccess()) {
			context.setResultObject(iReturnResult.getErrorResult());
		}
	}

}
